package com.glucozo.book_market.welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.glucozo.book_market.MainActivity
import com.glucozo.book_market.databinding.ActivitySplashBinding
import com.glucozo.book_market.login.LoginActivity
import com.glucozo.book_market.user_manager.UserManagement
import com.glucozo.book_market.user_manager.UserManagementImpl
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class WelcomeActivity : AppCompatActivity() {
    @Inject
    lateinit var userManagement: UserManagement

    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        println("checkLogged")
        checkLogged()
    }

    private fun checkLogged() {
        if (userManagement.isLogged()) {
            println("checkLogged: is Logged")
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            println("checkLogged: is not Logged")
            addEvents()
        }
    }

    private fun addEvents() {
        binding.button.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}