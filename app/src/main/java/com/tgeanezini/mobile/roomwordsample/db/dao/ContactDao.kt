package com.tgeanezini.mobile.roomwordsample.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tgeanezini.mobile.roomwordsample.db.entity.Contact

@Dao
interface ContactDao {
    @Insert
    suspend fun insert(contact: Contact)

    @Query("DELETE FROM contacts")
    fun deleteAll()

    @Delete
    fun deleteContact(contact: Contact)

    @Update
    fun updateContact(contact: Contact)

    @Query("SELECT * FROM contacts ORDER BY first_name ASC")
    fun getAllContacts() : LiveData<List<Contact>>
}