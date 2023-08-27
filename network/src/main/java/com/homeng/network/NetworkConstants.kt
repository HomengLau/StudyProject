package com.homeng.network

class NetworkConstants {
    companion object {
        // 是否开启网络调试
        var isDebug = false
        var isDebugInfo = false

        // 给定设置默认服务器地址
        var APP_DEFAULT_DOMAIN = "www.baidu.com"

        /**
         * 设置调试模式
         */
        fun setDebug(debugModel: Boolean){
            isDebug = debugModel
        }
    }

}