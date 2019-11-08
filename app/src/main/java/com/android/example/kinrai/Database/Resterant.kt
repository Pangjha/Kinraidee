package com.android.example.kinrai


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "rests_table")
data class Resterant (
    @PrimaryKey(autoGenerate = true)
    var restId: Long = 0L,

    @ColumnInfo(name = "name")
    val name: String = "No card name",

    @ColumnInfo(name = "photo")
    var photo: ByteArray

)