package com.rahulumak.greedygame.ggassignment.extension

import com.google.gson.annotations.SerializedName

data class ErrorModel(
    @SerializedName("error")
    val error: Int,

    @SerializedName("message")
    val message: String
) {
}