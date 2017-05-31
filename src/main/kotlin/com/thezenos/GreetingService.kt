package com.thezenos

import org.springframework.stereotype.Service

@Service
class GreetingService {
    fun greet(name: String): String {
        return "Hello, $name!"
    }
}