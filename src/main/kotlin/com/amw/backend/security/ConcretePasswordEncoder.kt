package com.amw.backend.security

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import java.security.MessageDigest


class ConcretePasswordEncoder {

    companion object {
        @JvmStatic
        fun getPasswordEncoder(): PasswordEncoder {
            return SimpleMD5PasswordEncoder()
        }
    }

    class SimpleMD5PasswordEncoder : PasswordEncoder {
        override fun encode(rawPassword: CharSequence?): String {
            return rawPassword?.let { md5(it.toString()) } ?: ""
        }

        override fun matches(rawPassword: CharSequence?, encodedPassword: String?): Boolean {
            var password = encode(rawPassword)
            return password == encodedPassword
        }

        private fun md5(input: String): String {
            val md = MessageDigest.getInstance("MD5")
            val bytes = md.digest(input.toByteArray())
            return bytes.joinToString("") { "%02x".format(it) }
        }
    }
}