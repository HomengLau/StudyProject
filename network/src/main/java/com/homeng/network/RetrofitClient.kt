package com.homeng.network

import com.homeng.network.NetworkConstants.Companion.APP_DEFAULT_DOMAIN
import com.tencent.mars.xlog.Log
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.logging.HttpLoggingInterceptor

class RetrofitClient private constructor() {
    companion object {
        private val TAG = RetrofitClient::class.simpleName

        val instance = RetrofitClientHolder.holder

        /**
         * 根据默认服务器地址生成retrofit
         */
        fun getRetrofitClient(): Retrofit {
            if (NetworkConstants.isDebug) {
                Log.d(TAG, "getClient() ==>")
            }
            return instance.retrofitMap[APP_DEFAULT_DOMAIN] ?: instance.createRetrofit(
                APP_DEFAULT_DOMAIN
            ).also {
                instance.retrofitMap[APP_DEFAULT_DOMAIN] = it
            }
        }

        /**
         * 针对不同的BaseUrl生成对饮的Retrofit
         */
        fun getRetrofitClient(baseUrl: String): Retrofit {
            if (NetworkConstants.isDebug) {
                Log.d(TAG, "getClient() ==> baseUrl : $baseUrl")
            }
            return instance.retrofitMap[baseUrl] ?: instance.createRetrofit(baseUrl).also {
                instance.retrofitMap[baseUrl] = it
            }
        }

        fun getOkHttpClient(): OkHttpClient {
            return instance.httpClient
        }
    }
    /**
     * 存储不同URL的Retrofit
     */
    private val retrofitMap = mutableMapOf<String, Retrofit>()

    private var httpClient: OkHttpClient
    private var retrofitClient: Retrofit

    init {
        val httpClientBuilder = OkHttpClient.Builder()
        if (NetworkConstants.isDebug) {
            httpClientBuilder.addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }
        if (NetworkConstants.isDebugInfo) {
            httpClientBuilder.addNetworkInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }
        // 构建空的okHttpClient
        httpClient = httpClientBuilder.build()
        // 构建空Retrofit避免报错
        retrofitClient = Retrofit.Builder().build()
    }

    private object RetrofitClientHolder {
        val holder = RetrofitClient()
    }

    private fun createRetrofit(baseUrl: String): Retrofit {
        retrofitClient = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(httpClient) // 可以自定义 OkHttpClient 配置
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofitClient
    }
}
