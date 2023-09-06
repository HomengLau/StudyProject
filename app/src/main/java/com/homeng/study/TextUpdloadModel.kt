package com.homeng.study

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TextUpdloadModel: ViewModel() {
    companion object{
        private const val TAG = "TextUpdloadModel"
    }
    var runingUpload: MutableLiveData<HashMap<String,String>> = MutableLiveData(hashMapOf<String, String>())
    fun upload(fileName: String, url: String){
        var tempMap = runingUpload.value
        tempMap?.let {
            tempMap[fileName] = url
            Log.d(TAG, "upload: 添加上传文件到列表: $fileName")
            runingUpload.postValue(tempMap)
        }
        runingUploadFile(fileName,url)

    }

    fun runingUploadFile(fileName: String,url: String){
        Log.e(TAG, "runingUploadFile: filename = $fileName", )
        Thread {
            Log.d(TAG, "runingUploadFile: currentThread : ${Thread.currentThread()}")
            Log.e(TAG, "runingUploadFile: currentThread : ${Thread.currentThread()}  => filename = $fileName", )
            Thread.sleep(100)
            Log.d(TAG, "runingUploadFile: 上传完成开始回调 - >$fileName")
            val runedList = runingUpload.value
            runedList.let {
                runedList?.remove(fileName)
                Log.e(TAG, "runingUploadFile: currentThread : ${Thread.currentThread()}  => filename = $fileName", )
                Log.d(TAG, "runingUploadFile: runedList : $runedList")
                runingUpload.postValue(runedList)
            }
        }.start()
    }
}