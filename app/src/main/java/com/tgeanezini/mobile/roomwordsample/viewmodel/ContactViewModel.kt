package com.tgeanezini.mobile.roomwordsample.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.tgeanezini.mobile.roomwordsample.db.database.ContactDatabase
import com.tgeanezini.mobile.roomwordsample.db.entity.Contact
import com.tgeanezini.mobile.roomwordsample.db.repository.ContactRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ContactRepository
    val allContacts: LiveData<List<Contact>>

    init {
        val contactsDao = ContactDatabase.getDatabase(application, viewModelScope).contactDao()
        repository = ContactRepository(contactsDao)
        allContacts = repository.allContacts
    }

    fun insert(contact: Contact) = viewModelScope.launch(Dispatchers.IO) { repository.insert(contact)  }
}