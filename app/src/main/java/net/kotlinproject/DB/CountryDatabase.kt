package net.kotlinproject.db

import androidx.room.Database
import androidx.room.RoomDatabase
import net.kotlinproject.model.CountryModel

@Database(entities = [(CountryModel::class)], version = 1)
abstract class CountryDatabase :RoomDatabase(){

    abstract fun countryDao() : CountryDao
}




