package com.homeng.network

import okhttp3.ResponseBody
 open class BaseResult<T> constructor(){
    var code = -1
    var msg = ""
    var data: T? = null

    constructor(msg:String?) : this() {
        if (!msg.isNullOrEmpty()) {
            this.msg = msg
        }
    }

    fun isSuccess(): Boolean {
        if (code == 0){
            return true
        }
        return false
    }


    override fun toString(): String {
        return super.toString()
    }
}