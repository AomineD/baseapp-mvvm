package com.aomined.baseapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.aomined.baseapp.database.dao.SavedSearchDao
import com.aomined.baseapp.database.entity.SavedSearchEntity

@Database(entities = [SavedSearchEntity::class], version = 1)
@TypeConverters(ListConverter::class)
abstract class SavedDatabase:RoomDatabase() {
    abstract fun getSavedSearchDao(): SavedSearchDao
}