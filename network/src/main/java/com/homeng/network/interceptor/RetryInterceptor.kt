package com.homeng.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * 重试网络连接
 */
class RetryInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val maxAttempts = 3
        var response: Response? = null
        var exception: IOException? = null

        for (attempt in 1..maxAttempts) {
            try {
                response = chain.proceed(chain.request())
                if (response.isSuccessful) {
                    return response
                }
            } catch (e: IOException) {
                exception = e
            }
        }

        throw exception ?: IOException("Request failed after $maxAttempts attempts")

    }
}