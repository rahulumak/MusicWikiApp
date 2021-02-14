package com.rahulumak.greedygame.ggassignment.extension

sealed class ApiResponse<out T: Any> {
    data class Success<out T: Any>(val data: T): ApiResponse<T>()
    data class Error(val exception: ErrorModel): ApiResponse<ErrorModel>()
    object Loading: ApiResponse<Nothing>()

    fun toData(): T? = if(this is Success) this.data else null
}