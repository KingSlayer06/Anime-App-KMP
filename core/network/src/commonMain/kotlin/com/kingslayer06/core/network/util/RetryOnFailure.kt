package com.kingslayer06.core.network.util

import kotlinx.coroutines.delay

suspend fun <T> retryOnFailure(
    maxRetries: Int = 3,
    initialDelay: Long = 2000L,
    block: suspend () -> Response<T, DataError>
): Response<T, DataError> {
    var lastResponse: Response<T, DataError>

    for (attempt in 0 until maxRetries) {
        lastResponse = block()

        when (lastResponse) {
            is Response.Success -> return lastResponse
            is Response.Error -> {
                if (lastResponse.error == DataError.TooManyRequests) {
                    delay(initialDelay * (attempt + 1))
                } else {
                    return lastResponse
                }
            }
        }
    }

    return block()
}