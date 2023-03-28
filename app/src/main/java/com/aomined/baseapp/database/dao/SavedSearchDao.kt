package com.aomined.baseapp.database.dao

import androidx.room.Dao

@Dao
interface SavedSearchDao {
   /* @Query("SELECT * FROM saved_table ORDER BY timeLong DESC")
    suspend fun getAllSaved():List<SavedSearchEntity>

    @Insert(onConflict = REPLACE)
    suspend fun insertSaved(search:SavedSearchEntity)

    @Query("SELECT * FROM saved_table WHERE savedTitle = :savedTitleFrom LIMIT 1")
    suspend fun getIfExist(savedTitleFrom:String):SavedSearchEntity?

    @Delete
    suspend fun deleteSavedById(savedSearch:SavedSearchEntity)*/
}