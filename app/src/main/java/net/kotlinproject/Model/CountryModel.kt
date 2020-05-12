package net.kotlinproject.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Countries")
data class CountryModel (

        @PrimaryKey
        val name : String,
        val capital : String,
        val population : Int,
        val flag:String

)

