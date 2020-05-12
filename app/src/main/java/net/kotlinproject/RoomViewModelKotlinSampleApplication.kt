package net.kotlinproject

import android.app.Application
import androidx.room.Room
import net.kotlinproject.db.CountryDatabase

class RoomViewModelKotlinSampleApplication : Application() {

    companion object {
        var database: CountryDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        database =  Room.databaseBuilder(applicationContext, CountryDatabase::class.java, "country_db").fallbackToDestructiveMigration().build()
    }
}