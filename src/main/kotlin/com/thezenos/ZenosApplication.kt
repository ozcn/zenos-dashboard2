package com.thezenos

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class ZenosApplication

fun main(args: Array<String>) {
    SpringApplication.run(ZenosApplication::class.java, *args)
}
