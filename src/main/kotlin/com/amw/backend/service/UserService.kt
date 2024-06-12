package com.amw.backend.service


import com.amw.backend.model.User
import com.amw.backend.repository.UserRepository
import com.amw.backend.security.ConcretePasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
) {

    fun registerUser(user: User): User {
        user.setPassword(ConcretePasswordEncoder.getPasswordEncoder().encode(user.getPassword()!!))
        return userRepository.save(user)
    }

    fun userExists(username: String): Boolean {
        return userRepository.findByUsername(username) != null
    }

    fun authenticateUser(username: String, password: String): User? {
        val user = userRepository.findByUsername(username)

        if ((user != null) && ConcretePasswordEncoder.getPasswordEncoder().matches(
                password,
                user.getPassword()
            )
        ) {
            return user
        }

        return null
    }

}
