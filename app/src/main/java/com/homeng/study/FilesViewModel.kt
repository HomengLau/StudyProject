package com.homeng.study

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.homeng.study.files.FileManagerRepository
import java.io.File

class FilesViewModel: ViewModel() {
    var readyUploadCount: MutableLiveData<Int> = MutableLiveData(0)
    var uploadFile: MutableLiveData<ArrayList<String>>  = MutableLiveData(ArrayList())
    val isUploadComplete: MutableLiveData<Boolean> by lazy {
        MutableLiveData()
    }


    fun uploadFile(file: File) {
        var updatedCount = readyUploadCount.value as Int
        updatedCount++
        readyUploadCount.postValue(updatedCount)


        FileManagerRepository().uploadImageFile(file = file, callback = {
            if (!it.isNullOrEmpty()) {
                val updatedList = uploadFile.value ?: ArrayList()
                updatedList.add(it)
                uploadFile.postValue(updatedList)
                if (updatedList.size == readyUploadCount.value)
                    isUploadComplete.postValue(true)
            }
        })
    }
}