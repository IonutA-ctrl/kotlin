package soumyajitdas.com.roomviewmodelkotlinsample.DB


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import soumyajitdas.com.roomviewmodelkotlinsample.Model.CountryModel

@Dao
interface CountryDao {

    @Query("SELECT * FROM Countries")
    fun getAllCountries() : LiveData<List<CountryModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCountries(countryList: List<CountryModel>)

    @Query("DELETE FROM Countries")
    fun deleteAllCountries()
}