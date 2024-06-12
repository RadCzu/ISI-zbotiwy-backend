package com.amw.backend.repository

import com.amw.backend.model.User
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*


interface UserRepository : MongoRepository<User?, String?> {
    fun findByUsername(username: String): User?
}