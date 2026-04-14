package com.kingslayer06.core.network.util

interface Error

sealed interface DataError: Error {
    data object RequestTimeout: DataError
    data object TooManyRequests: DataError
    data object NoInternet: DataError
    data object Server: DataError
    data object Serialization: DataError
    data object Unknown: DataError
}

fun DataError.toErrorMessage(): String {
    return when (this) {
        DataError.RequestTimeout -> "Request timed out. Please try again."
        DataError.TooManyRequests -> "Too many requests. Please wait a moment."
        DataError.NoInternet -> "No internet connection."
        DataError.Server -> "Server error. Please try again later."
        DataError.Serialization -> "Data processing error."
        DataError.Unknown -> "An unexpected error occurred."
    }
}