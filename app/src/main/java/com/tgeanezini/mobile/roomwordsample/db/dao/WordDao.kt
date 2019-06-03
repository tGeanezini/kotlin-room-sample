package com.tgeanezini.mobile.roomwordsample.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.tgeanezini.mobile.roomwordsample.db.entity.Word

@Dao
interface WordDao {
    @Insert
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")
    fun deleteAll()

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAllWords(): LiveData<List<Word>>
}