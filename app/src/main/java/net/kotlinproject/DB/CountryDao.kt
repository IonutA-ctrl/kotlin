package net.kotlinproject.db


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import net.kotlinproject.model.CountryModel

@Dao
interface CountryDao {

    @Query("SELECT * FROM Countries")
    fun getAllCountries() : LiveData<List<CountryModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCountries(countryList: List<CountryModel>)

    @Query("DELETE FROM Countries")
    fun deleteAllCountries()
}