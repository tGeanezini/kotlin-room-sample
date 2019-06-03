package com.tgeanezini.mobile.roomwordsample.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.tgeanezini.mobile.roomwordsample.db.repository.WordRepository
import com.tgeanezini.mobile.roomwordsample.db.database.WordRoomDatabase
import com.tgeanezini.mobile.roomwordsample.db.entity.Word
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: WordRepository
    val allWords: LiveData<List<Word>>

    init {
        val wordsDao = WordRoomDatabase.getDatabase(application, viewModelScope).wordDao()
        repository = WordRepository(wordsDao)
        allWords = repository.allWords
    }

    /***
     * O insert será chamado fora da main thread utilizando uma coroutine. Nesse caso como é uma operação na base
     * de dados, é utilizado o Dispatcher de IO.
     */
    fun insert(word: Word) = viewModelScope.launch(Dispatchers.IO) { repository.insert(word) }
}