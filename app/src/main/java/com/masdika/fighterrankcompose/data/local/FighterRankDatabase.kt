package com.masdika.fighterrankcompose.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.masdika.fighterrankcompose.R
import com.masdika.fighterrankcompose.data.model.Fighter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Fighter::class], version = 1, exportSchema = false)
abstract class FighterRankDatabase : RoomDatabase() {

    abstract fun fighterDao(): FighterDao

    companion object {
        @Volatile
        private var INSTANCE: FighterRankDatabase? = null

        fun getInstance(context: Context): FighterRankDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FighterRankDatabase::class.java,
                    "fighter_rank.db"
                )
                    .addCallback(DatabaseCallback(context))
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

    private class DatabaseCallback(private val context: Context) : Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                CoroutineScope(Dispatchers.IO).launch {
                    prePopulateDatabase(
                        context = context,
                        fighterDao = database.fighterDao()
                    )
                }
            }
        }

        suspend fun prePopulateDatabase(context: Context, fighterDao: FighterDao) {
            val resources = context.resources
            val names = resources.getStringArray(R.array.fighter_names)
            val divisions = resources.getStringArray(R.array.fighter_divisions)
            val titles = resources.getStringArray(R.array.fighter_titles)
            val images = resources.getStringArray(R.array.fighter_images)
            val descriptions = resources.getStringArray(R.array.fighter_descriptions)
            val wins = resources.getIntArray(R.array.fighter_wins)
            val losses = resources.getIntArray(R.array.fighter_losses)
            val draws = resources.getIntArray(R.array.fighter_draws)
            val strikeAcc = resources.getIntArray(R.array.fighter_strike_accuracy)
            val takedownAcc = resources.getIntArray(R.array.fighter_takedown_accuracy)
            val koWins = resources.getIntArray(R.array.fighter_ko_wins)
            val subWins = resources.getIntArray(R.array.fighter_sub_wins)

            val fighterList = names.indices.map { i ->
                Fighter(
                    p4pRank = i + 1,
                    image = images[i],
                    name = names[i],
                    division = divisions[i],
                    description = descriptions[i],
                    wins = wins[i],
                    losses = losses[i],
                    draws = draws[i],
                    strikeAccuracy = strikeAcc[i].toDouble(),
                    takedownAccuracy = takedownAcc[i].toDouble(),
                    knockOutWins = koWins[i],
                    submissionWins = subWins[i],
                    title = titles[i]
                )
            }

            fighterDao.insertAll(fighterList)
        }

    }
}

/*
   1. `@Database(...)`: Anotasi utama.
       * entities = [Fighter::class]: Mendaftarkan semua kelas entitas yang akan dikelola oleh database ini.
       * version = 1: Versi database. Jika mengubah skema (misalnya, menambah kolom), maka harus menaikkan nomor versi ini.
       * exportSchema = false: Mencegah Room mengekspor skema database ke dalam sebuah file JSON. Untuk proyek ini, kita bisa menonaktifkannya.

   2. `abstract fun fighterDao(): FighterDao`: Room akan mengimplementasikan fungsi ini untuk menyediakan akses ke FighterDao yang sudah kita buat.

   3. `companion object` (Singleton Pattern):
       * Ini adalah pola desain untuk memastikan hanya ada satu instance dari FighterRankDatabase di seluruh aplikasi. Membuat banyak instance database adalah operasi
         yang berat dan bisa menyebabkan masalah.
       * @Volatile: Anotasi ini memastikan bahwa nilai INSTANCE akan selalu up-to-date di semua thread.
       * synchronized(this): Blok ini memastikan bahwa hanya satu thread yang bisa membuat instance database pada satu waktu, mencegah race condition.

   4. `DatabaseCallback` (Proses Seeding):
       * `.addCallback(...)`: Saat membangun database, kita mendaftarkan DatabaseCallback kita.
       * `override fun onCreate(...)`: Metode ini hanya akan dipanggil satu kali seumur hidup aplikasi, yaitu saat file database fighter_rank.db pertama kali dibuat.
         Metode ini tidak akan dipanggil lagi pada saat aplikasi dibuka kembali.
       * `CoroutineScope(Dispatchers.IO).launch`: Di dalam onCreate, kita meluncurkan coroutine di I/O thread untuk menjalankan operasi prePopulateDatabase. Ini penting
         agar proses seeding yang berpotensi lambat tidak mengganggu Main Thread.
       * `prePopulateDatabase(...)`: Di sinilah keajaiban terjadi. Fungsi ini:
           1. Mengambil semua data dari arrays.xml menggunakan context.resources.
           2. Melakukan looping (.map) untuk mengubah setiap set data menjadi objek Fighter.
           3. Memanggil fighterDao.insertAll(fighterList) untuk menyimpan seluruh daftar objek Fighter ke dalam database. Ini adalah saat dimana fun insertAll yang kita
              buat di DAO akhirnya digunakan.
* */