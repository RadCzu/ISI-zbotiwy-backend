package com.amw.backend.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@ConfigurationProperties(prefix = "security.jwt")
data class JwtProperties(
    var key: String = "",
    var accessTokenExpiration: Long = 0,
    var refreshTokenExpiration: Long = 0
)