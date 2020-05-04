package net.kotlinproject.utils

import net.kotlinproject.data.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET(value = "/users")
    fun fetchAllUsers() : Call<List<User>>
}