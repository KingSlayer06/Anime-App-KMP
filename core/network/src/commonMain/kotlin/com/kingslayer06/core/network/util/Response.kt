package com.kingslayer06.core.network.util

sealed interface Response<out D, out E: Error> {
    data class Success<out D>(val data: D): Response<D, Nothing>
    data class Error<out E: com.kingslayer06.core.network.util.Error>(val error: E):
        Response<Nothing, E>
}

inline fun <T, E: Error, R> Response<T, E>.map(map: (T) -> R): Response<R, E> {
    return when(this) {
        is Response.Success -> Response.Success(map(data))
        is Response.Error -> Response.Error(error)
    }
}

fun <T, E: Error> Response<T, E>.asEmptyDataResult(): EmptyResult<E> {
    return map {  }
}

inline fun <T, E: Error> Response<T, E>.onSuccess(action: (T) -> Unit): Response<T, E> {
    return when(this) {
        is Response.Success -> {
            action(data)
            this
        }
        is Response.Error -> this
    }
}
inline fun <T, E: Error> Response<T, E>.onFailure(action: (E) -> Unit): Response<T, E> {
    return when(this) {
        is Response.Success -> this
        is Response.Error -> {
            action(error)
            this
        }
    }
}

typealias EmptyResult<E> = Response<Unit, E>