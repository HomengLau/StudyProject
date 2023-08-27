package com.homeng.study.files

import android.annotation.SuppressLint
import com.homeng.network.BaseAction
import com.homeng.network.BaseResult
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

class FileManagerRepository: BaseAction() {
    private val fileMgrApiService = createService(FileMgrApiService::class.java)
    @SuppressLint("CheckResult", "SuspiciousIndentation")
    fun uploadImageFile(file: File, callback: (String?) -> Unit) {
        val requestFile = file.asRequestBody("image/*".toMediaTypeOrNull())
        val body = MultipartBody.Part.createFormData("file", file.name, requestFile)

        fileMgrApiService.uploadFile(body)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    if (!response.data.isNullOrEmpty())
                    // 处理成功响应，response.body() 中可能包含上传后的文件信息
                    callback(response.data!!)
                },
                { error ->
                    // 处理错误情况

                    callback(error.message)
                }
            )
    }
}