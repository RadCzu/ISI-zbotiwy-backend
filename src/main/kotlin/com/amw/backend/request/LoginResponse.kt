package com.amw.backend.request

data class LoginResponse (
    val token: String,
    val username: String,
)