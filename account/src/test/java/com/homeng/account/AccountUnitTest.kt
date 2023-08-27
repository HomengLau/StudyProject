package com.homeng.account

import kotlinx.coroutines.runBlocking
import okhttp3.Request
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AccountUnitTest {

    @Test
    fun testFetchUsers() {
        val mockWebServer = MockWebServer()
        val request = Request.Builder()
        mockWebServer.enqueue(MockResponse().setBody(request.build().toString()))

        val apiService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserMgrApiService::class.java)

        val userRepository = UserMgrAction(apiService)
        val users = runBlocking { userRepository.getUsers() }

        // Perform assertions on the users list
    }

}