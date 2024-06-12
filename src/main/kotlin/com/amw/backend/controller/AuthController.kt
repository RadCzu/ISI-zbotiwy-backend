package com.amw.backend.controller

import com.amw.backend.model.User
import com.amw.backend.request.LoginRequest
import com.amw.backend.request.LoginResponse
import com.amw.backend.service.AuthenticationService
import com.amw.backend.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = arrayOf("http://localhost:4200", "http://192.168.88.120:4200", "http://192.168.88.69:4200", "http://localhost:8099"))
class AuthController(
    private val userService: UserService,
    private val authenticationService: AuthenticationService,
) {

    @PostMapping("/register")
    fun registerUser(@RequestBody loginRequest: LoginRequest): ResponseEntity<String> {

        if (userService.userExists(loginRequest.username)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists")
        } else {
            val user = User().apply {
                val roles: List<String> = listOf("Users")
                setUsername(loginRequest.username)
                //setPassword(ConcretePasswordEncoder.getPasswordEncoder().encode(loginRequest.password))
                setPassword(loginRequest.password)
                setRoles(roles)
            }
            userService.registerUser(user)
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully")
        }
    }


    @PostMapping("/login")
    fun loginUser(@RequestBody loginRequest: LoginRequest): LoginResponse {
        val user = userService.authenticateUser(loginRequest.username, loginRequest.password)

        if (user != null) {
            return authenticationService.authenticate(loginRequest)
        } else {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Login failed")
        }
    }

    @GetMapping("/logout")
    fun logoutUser(): ResponseEntity<String> {
        return ResponseEntity.ok("User logged out successfully")
    }
}