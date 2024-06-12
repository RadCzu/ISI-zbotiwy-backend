package com.amw.backend.controller

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {

    @CrossOrigin(origins = arrayOf("http://localhost:4200", "http://192.168.88.120:4200", "http://192.168.88.69:4200"))
    @GetMapping("/api/hello")
    fun sayHelloWorld() : String {
        return "Hello World!"
    }
}

