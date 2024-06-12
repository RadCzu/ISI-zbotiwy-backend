package com.amw.backend.service

import com.amw.backend.repository.UserRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

typealias AppUser = com.amw.backend.model.User

@Service
class CustomUserDetailsService(
    private val userRepository: UserRepository
): UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        return userRepository.findByUsername(username!!)
            ?.mapToUserService()
            ?:throw UsernameNotFoundException("NOT FOUND")
    }

    private fun AppUser.mapToUserService(): UserDetails? {
        return User.builder()
            .username(this.getUsername())
            .password(this.getPassword())
            .roles(this.getRoles().toString())
            .build()
    }
}