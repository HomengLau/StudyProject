package com.homeng.study

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: FilesViewModel;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       viewModel = ViewModelProvider(this)[FilesViewModel::class.java]
        // 上传结束后监听完成标记
        viewModel.isUploadComplete.observe(this) {
            if (it) {
                //TODO 全部上传完成后进行操作
            }
        }
    }

}
