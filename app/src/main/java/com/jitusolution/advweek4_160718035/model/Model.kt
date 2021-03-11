package com.jitusolution.advweek4_160718035.model

import com.google.gson.annotations.SerializedName

data class Student(
    val id:String?,
    @SerializedName("student_name")
    val name:String?,
    @SerializedName("birth_of_date")
    val bod:String?,
    //bod = birth of date
    val phone:String?,
    @SerializedName("photo_url")
    val photoUrl:String?
)