package com.tgeanezini.mobile.roomwordsample.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tgeanezini.mobile.roomwordsample.models.Word

@Database(entities = [Word::class], version = 1)
abstract class WordRoomDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao

    companion object {
        @Volatile
        private var INSTANCE: WordRoomDatabase? = null

        fun getDatabase(context: Context): WordRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null)
                return tempInstance

            synchronized(this) {
                //Cria a database
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordRoomDatabase::class.java,
                    "Word_database").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}