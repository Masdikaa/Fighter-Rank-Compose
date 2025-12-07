package com.masdika.fighterrankcompose.data.repositories

import com.masdika.fighterrankcompose.data.local.FighterDao
import com.masdika.fighterrankcompose.data.model.Fighter
import kotlinx.coroutines.flow.Flow

class FighterRepository(private val fighterDao: FighterDao) {

    fun getAllFighters(): Flow<List<Fighter>> {
        return fighterDao.getAllFighters()
    }

    fun getFighterById(fighterId: Int): Flow<Fighter> {
        return fighterDao.getFighterById(fighterId)
    }

    companion object {
        @Volatile
        private var instance: FighterRepository? = null

        fun getInstance(dao: FighterDao): FighterRepository = instance ?: synchronized(this) {
            instance ?: FighterRepository(dao).also { instance = it }
        }
    }
}

/*
   1. `class FighterRepository(private val fighterDao: FighterDao)`:
       * Ini adalah konstruktor kelas. Perhatikan bahwa FighterRepository menerima FighterDao sebagai parameter. Ini disebut Dependency Injection. Repository
         "bergantung" pada DAO untuk mendapatkan data dari database.
       * Dengan mendesainnya seperti ini, kita memisahkan tanggung jawab. Repository tidak perlu tahu bagaimana data disimpan, ia hanya perlu tahu siapa yang harus
         diminta (yaitu fighterDao).

   2. `fun getAllFighters(): Flow<List<Fighter>>`:
       * Fungsi ini sangat sederhana. Ia hanya meneruskan (pass-through) permintaan dari ViewModel ke fighterDao.getAllFighters() dan mengembalikan Flow yang diberikan
         oleh DAO.
       * Di masa depan, jika ingin menambahkan sumber data lain (misalnya, mengambil data terbaru dari API internet), logikanya akan ditempatkan di sini.
         Repository bisa memutuskan apakah akan mengambil data dari database (cache) atau dari jaringan, lalu menyimpannya ke database. ViewModel tidak perlu tahu
         tentang kerumitan ini.

   3. `companion object` (Singleton Pattern):
       * Sama seperti database, kita juga menjadikan Repository sebagai singleton. Ini untuk memastikan bahwa seluruh aplikasi menggunakan satu instance Repository yang
         sama, yang konsisten dan hemat sumber daya.
       * Fungsi getInstance menerima FighterDao dan menggunakannya untuk membuat instance FighterRepository.
*/