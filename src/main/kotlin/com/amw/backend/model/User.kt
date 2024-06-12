package com.amw.backend.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "users")
class User {
    @Id
    private var id: String? = null
    private var username: String? = null
    private var password: String? = null
    private var roles: List<String>? = null

    public fun getUsername(): String? {
        return username
    }

    public fun getPassword(): String? {
        return password
    }

    public fun getRoles(): List<String>? {
        return roles
    }

    public fun getId(): String? {
        return id
    }

    public fun setPassword(password: String) {
        this.password = password;
    }

    public fun setUsername(username: String) {
        this.username = username
    }

    public fun setRoles(roles: List<String>) {
        this.roles = roles
    }

    public fun setId(id: String) {
        this.id = id
    }
}