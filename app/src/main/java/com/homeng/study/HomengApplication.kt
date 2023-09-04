package com.homeng.study

import android.app.Application
import com.homeng.logger.Logs

class HomengApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Logs.initData(applicationContext)
    }
}