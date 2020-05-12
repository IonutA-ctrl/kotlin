package net.kotlinproject.activity



import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import net.kotlinproject.model.CountryModel

class ListViewModel : ViewModel() {

     var mainActivityRepository: ListActivityRepository

    init {
        mainActivityRepository = ListActivityRepository()
    }

    fun getAllCountryList(): LiveData<List<CountryModel>>?
    {
        return mainActivityRepository.getCountries()
    }

    fun getCountriesFromAPIAndStore()
    {
        mainActivityRepository.ApiCallAndPutInDB()
    }


}