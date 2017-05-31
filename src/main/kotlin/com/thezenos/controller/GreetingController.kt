package com.thezenos.controller

import com.thezenos.GreetingService
import java.util.concurrent.atomic.AtomicLong

import com.thezenos.entity.Greeting
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController(val service: GreetingService) {
    val counter = AtomicLong()

    @RequestMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String): Greeting {
        return Greeting(counter.incrementAndGet(), service.greet(name))
    }
}
