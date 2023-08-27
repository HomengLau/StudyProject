package com.homeng.network

import okhttp3.OkHttpClient

open class BaseAction {

    fun <T> createService(service: Class<T>): T {
        return RetrofitClient.getRetrofitClient().create(service)
    }

    fun <T> createService(baseUrl: String, service: Class<T>): T {
        return RetrofitClient.getRetrofitClient(baseUrl).create(service)
    }

    fun getHttpClient(): OkHttpClient {
        return RetrofitClient.getOkHttpClient()
    }
}