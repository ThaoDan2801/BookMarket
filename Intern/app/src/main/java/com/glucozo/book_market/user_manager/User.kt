package com.glucozo.book_market.user_manager

data class User(
    val userId: Int,
    val username: String,
    val password: String,
    val token: String,
    val email: String
)