package com.tgeanezini.mobile.roomwordsample.db.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.tgeanezini.mobile.roomwordsample.db.dao.ContactDao
import com.tgeanezini.mobile.roomwordsample.db.entity.Contact
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDao

    companion object {
        @Volatile
        private var INSTANCE: ContactDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope) : ContactDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null)
                return tempInstance

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ContactDatabase::class.java,
                    "Contact_database").addCallback(
                    ContactDatabaseCallback(scope)
                ).build()
                INSTANCE = instance
                return instance
            }
        }

        private class ContactDatabaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback() {
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                INSTANCE?.let {database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.contactDao())
                    }
                }
            }
        }

        suspend fun populateDatabase(contactDao: ContactDao) {
            contactDao.deleteAll()
            val contact = Contact("Tiago", "Geanezini")
            contactDao.insert(contact)
        }
    }
}