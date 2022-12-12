package com.glucozo.book_market.user_manager

import android.content.Context
import android.content.SharedPreferences
import com.glucozo.book_market.common.Constants.UserData
import com.glucozo.book_market.common.Constants.UserManager
import com.google.gson.Gson
import javax.inject.Inject

interface UserManagement {
    fun saveUser(user: User)

    fun getUser(): User

    fun isLogged(): Boolean
}

class UserManagementImpl @Inject constructor(val context: Context) : UserManagement {
    private val gson = Gson()
    private var sharedPreferences: SharedPreferences =
        context.getSharedPreferences(UserManager, Context.MODE_PRIVATE)

    override fun saveUser(user: User) {
        val dataUser: String = gson.toJson(user)
        sharedPreferences.edit().putString(UserData, dataUser).apply()
    }

    override fun getUser(): User {
        val dataUser: String = sharedPreferences.getString(UserData, "") ?: ""
        return gson.fromJson(dataUser, User::class.java)
    }

    override fun isLogged(): Boolean {
        val dataUser: String = sharedPreferences.getString(UserData, "") ?: ""
        return dataUser.isNotEmpty()
    }
}
