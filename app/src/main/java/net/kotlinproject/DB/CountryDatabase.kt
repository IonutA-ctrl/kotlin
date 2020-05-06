package soumyajitdas.com.roomviewmodelkotlinsample.DB

import androidx.room.Database
import androidx.room.RoomDatabase
import soumyajitdas.com.roomviewmodelkotlinsample.Model.CountryModel

@Database(entities = [(CountryModel::class)], version = 1)
abstract class CountryDatabase :RoomDatabase(){

    abstract fun countryDao() : CountryDao
}




