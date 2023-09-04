package com.homeng.logger

import android.content.Context
import android.os.Environment
import com.tencent.mars.BuildConfig
import com.tencent.mars.xlog.Log
import com.tencent.mars.xlog.Xlog

class Logs {
    companion object {
        fun initData(context: Context) {
            System.loadLibrary("c++_shared");
            System.loadLibrary("marsxlog");

            val SDCARD = Environment.getExternalStorageDirectory().absolutePath;
            val logPath = "$SDCARD/marssample/log";

            // this is necessary, or may cash for SIGBUS
            val cachePath = "${context.filesDir}/xlog"

            //init xlog
            val xlog = Xlog();
            Log.setLogImp(xlog);

            if (BuildConfig.DEBUG) {
                Log.setConsoleLogOpen(true);
                Log.appenderOpen(
                    Xlog.LEVEL_DEBUG,
                    Xlog.AppednerModeAsync,
                    cachePath,
                    logPath,
                    "aplog_${System.currentTimeMillis()}",
                    0
                );
            } else {
                Log.setConsoleLogOpen(false);
                Log.appenderOpen(
                    Xlog.LEVEL_INFO,
                    Xlog.AppednerModeAsync,
                    cachePath,
                    logPath,
                    "aplog_${System.currentTimeMillis()}",
                    0
                );
            }
        }
    }
}