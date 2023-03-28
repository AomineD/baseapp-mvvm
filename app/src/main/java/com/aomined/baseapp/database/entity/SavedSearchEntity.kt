package com.aomined.baseapp.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saved_table")
data class SavedSearchEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id:Int = 0,
    @ColumnInfo(name = "savedTitle") val savedTitle:String,
    @ColumnInfo(name = "list") val list: List<String>,
    @ColumnInfo(name = "timeLong") val timeLong:Long)
/*
fun ApiResponse.toDatabase(title:String): SavedSearchEntity {
    return SavedSearchEntity(
        savedTitle = title,
        list = images,
        timeLong = System.currentTimeMillis()
    )
}*/
