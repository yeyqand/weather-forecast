package com.yeyq.weather.core.exception

import retrofit2.HttpException
import javax.inject.Inject

class ErrorWrapperImpl @Inject constructor() : ErrorWrapper {
    override fun wrap(throwable: Throwable): Throwable {
        return when (throwable) {
            is HttpException -> wrapServerError(throwable)
            else -> throwable
        }
    }

    private fun wrapServerError(httpException: HttpException): Throwable {
        return with(httpException) {
            when (code()) {
                400 -> ServerException.BadRequest(message())
                500 -> ServerException.Internal(message())
                else -> ServerException.Unknown(message())
            }
        }
    }
}

suspend fun <T> callOrThrow(
    errorWrapper: ErrorWrapper,
    apiCall: suspend () -> T
): T {
    return runCatching { apiCall() }
        .getOrElse { throw errorWrapper.wrap(it) }
}