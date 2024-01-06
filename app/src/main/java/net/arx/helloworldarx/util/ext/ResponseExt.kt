package net.arx.helloworldarx.util.ext

import retrofit2.Response

fun <T : Any> Response<T>.requireNotNull(): T {
    require(isSuccessful && body() != null)
    return body()!!
}