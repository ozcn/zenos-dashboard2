package com.thezenos.controller

import java.time.Duration
import java.util.*
import java.util.stream.Stream
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class HelloController {

    @GetMapping("/hello")
    fun hello(): Flux<String> {
        return Flux.just("Hello", "World")
    }

    @GetMapping("/stream")
    fun stream(): Flux<Map<String, Int>> {
        val stream = Stream.iterate(0) { it + 1 } // Java8の無限Stream
        return Flux.fromStream(stream).zipWith(Flux.interval(Duration.ofSeconds(1)))
                .map { Collections.singletonMap("value", it.t1) }
    }

    @PostMapping("/echo")
    fun echo(@RequestBody body: Mono<String>): Mono<String> {
        return body.map { it.toUpperCase() }
    }

    @PostMapping("/stream")
    fun stream(@RequestBody body: Flux<Map<String, Int>>): Flux<Map<String, Int>> {
        return body.map { Collections.singletonMap("double", it["value"]!! * 2) }
    }
}
