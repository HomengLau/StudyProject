package com.homeng.account

import android.database.Observable
import com.homeng.account.bean.LoginUserResult
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET

interface UserMgrApiService {
    @GET("account/login/check")
    suspend fun getUsers(@Body json: RequestBody): Observable<LoginUserResult>
}