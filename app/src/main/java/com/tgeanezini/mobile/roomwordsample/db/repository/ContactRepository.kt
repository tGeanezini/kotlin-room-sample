package com.tgeanezini.mobile.roomwordsample.db.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.tgeanezini.mobile.roomwordsample.db.dao.ContactDao
import com.tgeanezini.mobile.roomwordsample.db.entity.Contact

class ContactRepository(private val contactDao: ContactDao) {
    val allContacts: LiveData<List<Contact>> = contactDao.getAllContacts()

    @WorkerThread
    suspend fun insert(contact: Contact) {
        contactDao.insert(contact)
    }
}