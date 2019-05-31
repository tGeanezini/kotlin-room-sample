package com.tgeanezini.mobile.roomwordsample.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
class Contact(
    @ColumnInfo(name = "first_name") val firstName: String,
    @ColumnInfo(name = "last_name") val lastName: String
) {
    @PrimaryKey(autoGenerate = true) val id: Int = 0
}