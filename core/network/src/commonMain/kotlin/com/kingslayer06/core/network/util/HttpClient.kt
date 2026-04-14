package com.kingslayer06.core.network.util

import io.ktor.client.call.NoTransformationFoundException
import io.ktor.client.call.body
import io.ktor.client.network.sockets.SocketTimeoutException
import io.ktor.client.statement.HttpResponse
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.ensureActive

suspend inline fun <reified T> safeCall(
    execute: () -> HttpResponse
): Response<T, DataError> {
    val response = try {
        execute()
    } catch(e: SocketTimeoutException) {
        return Response.Error(DataError.RequestTimeout)
    } catch(e: UnresolvedAddressException) {
        return Response.Error(DataError.NoInternet)
    } catch (e: Exception) {
        currentCoroutineContext().ensureActive()
        return Response.Error(DataError.Unknown)
    }

    return responseToResult(response)
}

suspend inline fun <reified T> responseToResult(
    response: HttpResponse
): Response<T, DataError> {
    return when(response.status.value) {
        in 200..299 -> {
            try {
                Response.Success(response.body<T>())
            } catch(e: NoTransformationFoundException) {
                Response.Error(DataError.Serialization)
            }
        }
        408 -> Response.Error(DataError.RequestTimeout)
        429 -> Response.Error(DataError.TooManyRequests)
        in 500..599 -> Response.Error(DataError.Server)
        else -> Response.Error(DataError.Unknown)
    }
}