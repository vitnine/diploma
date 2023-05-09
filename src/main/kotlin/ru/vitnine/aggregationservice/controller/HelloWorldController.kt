package ru.vitnine.aggregationservice.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {

    @GetMapping("/")
    fun getHelloWorldMessage(): ResponseEntity<String> {
        return ResponseEntity.ok("Hello from controller")
    }
}