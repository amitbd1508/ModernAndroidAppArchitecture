package me.amitghosh.modernandroidapparchitecture.data

import androidx.room.*
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey



@Entity(tableName = "Books")
data class Book(
    @PrimaryKey @ColumnInfo(name = "id") val bookId: String,
    val name: String,
    val description: String,
    val price: Int = 0
)