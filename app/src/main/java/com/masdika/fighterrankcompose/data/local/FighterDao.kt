package com.masdika.fighterrankcompose.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.masdika.fighterrankcompose.data.model.Fighter
import kotlinx.coroutines.flow.Flow

@Dao
interface FighterDao {
    /**
     * Mengambil semua data fighter dari tabel, diurutkan berdasarkan p4pRank (peringkat).
     * Menggunakan Flow agar UI bisa otomatis update saat ada perubahan data di database.
     */
    @Query("SELECT * FROM fighters ORDER BY p4pRank ASC")
    fun getAllFighters(): Flow<List<Fighter>>

    /**
     * Mengambil satu data fighter berdasarkan ID-nya.
     * Berguna untuk halaman detail.
     */
    @Query("SELECT * FROM fighters WHERE id = :fighterId")
    fun getFighterById(fighterId: Int): Flow<Fighter>

    /**
     * Insert daftar fighter ke dalam database.
     * Berperan sebagai seeder untuk mengisi data awal dari strings.xml.
     * Jika data sudah ada (berdasarkan Primary Key), data tersebut akan diganti.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(fighters: List<Fighter>)
}
