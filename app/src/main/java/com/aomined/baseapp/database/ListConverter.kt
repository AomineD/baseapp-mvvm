package com.aomined.baseapp.database

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*

@ProvidedTypeConverter
class ListConverter {
    @TypeConverter
    fun toStringList(listValuesString: String?): List<String?>? {
        if (listValuesString == null) {
            return Collections.emptyList()
        }
        val type: Type = object : TypeToken<List<String?>?>() {}.type
        return Gson().fromJson(listValuesString, type)
    }
    @TypeConverter
    fun fromStringList(listValues: List<String?>?): String? {
        val type: Type = object : TypeToken<List<String?>?>() {}.type
        return Gson().toJson(listValues, type)
    }
}