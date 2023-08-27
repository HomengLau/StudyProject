package com.homeng.study.files

import com.homeng.network.BaseResult
import io.reactivex.rxjava3.core.Single
import okhttp3.MultipartBody
import retrofit2.http.Headers
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface FileMgrApiService {
    @Multipart
    @Headers("content-type: multipart/form-data; boundary=---000000")
    @POST("upload")
    fun uploadFile(@Part file: MultipartBody.Part): Single<BaseResult<String>>
}