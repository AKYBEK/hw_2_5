package com.example.hw_2

import com.google.gson.annotations.SerializedName

data class LoveModel(
    @SerializedName("fname")
    var firstfName:String,
    @SerializedName("sname")
    var secondsName:String,
    var percentage:String,
    var result:String,
)
