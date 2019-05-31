package com.tgeanezini.mobile.roomwordsample.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/***
 * Entity -> representa uma tabela no repositório, caso um nome não seja dado, a tabela terá o mesmo nome da classe
 * ColumnInfo -> representa o nome da coluna na table
 * Todos os campos armazenados na database precisam ou serem PUBLIC ou terem um método GETTER
 */

@Entity(tableName = "word_table")
class Word(@PrimaryKey @ColumnInfo(name = "word") val word: String)