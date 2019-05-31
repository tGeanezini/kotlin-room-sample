package com.tgeanezini.mobile.roomwordsample.database

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.tgeanezini.mobile.roomwordsample.models.Word

class WordRepository(private val wordDao: WordDao) {
    val allWords: LiveData<List<Word>> = wordDao.getAllWords()

    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}