package com.amw.backend.service

import com.amw.backend.config.JwtProperties
import com.amw.backend.request.LoginRequest
import com.amw.backend.request.LoginResponse
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Service
import java.util.*


@Service
class AuthenticationService(
    private val authManager: AuthenticationManager,
    private val userDetailsService: CustomUserDetailsService,
    private val tokenService: TokenService,
    private val jwtProperties: JwtProperties,
) {

    fun authenticate(loginRequest: LoginRequest): LoginResponse {
        authManager.authenticate(
            UsernamePasswordAuthenticationToken(
                loginRequest.username,
                loginRequest.password
            )
        )

        val user = userDetailsService.loadUserByUsername(loginRequest.username)
        val accessToken = tokenService.generate(
            user,
            Date(System.currentTimeMillis() + jwtProperties.accessTokenExpiration)
        )
        return LoginResponse(
            token = accessToken,
            username = user.username,
        )
    }

}