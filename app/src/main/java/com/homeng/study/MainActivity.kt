package com.homeng.study

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.homeng.study.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object{
        private const val TAG = "MainActivity"
    }

    lateinit var binding: ActivityMainBinding

    lateinit var viewModel: FilesViewModel
    lateinit var testViewModel: TextUpdloadModel
    val fileList = hashMapOf(
        "file1" to "filePath1",
        "file2" to "filePath1",
        "file3" to "filePath1",
        "file4" to "filePath1",
        "file5" to "filePath1",
        "file6" to "filePath1",
        "file7" to "filePath1",
        "file8" to "filePath1",
        "file9" to "filePath1",
        "file10" to "filePath1",
        "file11" to "filePath1",
        "file12" to "filePath1",
    )
    var forCount = fileList.size
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.startGZ.setOnClickListener {
            uploadFile()
        }
        viewModel = ViewModelProvider(this)[FilesViewModel::class.java]
        testViewModel = ViewModelProvider(this)[TextUpdloadModel::class.java]
        // 上传结束后监听完成标记
        viewModel.isUploadComplete.observe(this) {
            if (it) {
                //TODO 全部上传完成后进行操作
            }
        }
        testViewModel.runingUpload.observe(this){
            Log.d(TAG, "onCreate: 带传输的列表变化了： runingUpload : $it")
            if (forCount == 0 && it.size == 0) {
                Log.v(TAG, " 传输完成了")
            }
        }

    }
    fun uploadFile(){
        Log.d(TAG, "uploadFile: 开始上传")
        for (item in fileList){
            Thread.sleep(500)
            Log.d(TAG, "uploadFile: item $item")
            testViewModel.upload(item.key,item.value)
            --forCount
        }
    }

}
