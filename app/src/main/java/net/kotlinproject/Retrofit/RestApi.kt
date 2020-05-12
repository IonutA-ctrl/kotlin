package net.kotlinproject.retrofit

import net.kotlinproject.model.CountryModel
import retrofit2.Call
import retrofit2.http.GET

interface RestApi {

    @GET("all")
    fun getAllCountries() : Call<List<CountryModel>>
}