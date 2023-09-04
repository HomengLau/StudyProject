package com.homeng.account

import com.homeng.account.bean.User

class UserMgrAction(private val apiService: UserMgrApiService) {
    suspend fun getUsers(): List<User> {
        return ArrayList()
    }
}