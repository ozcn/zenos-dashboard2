package com.thezenos.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class GreetingControllerTest {

    @Autowired
    private lateinit var controller: GreetingController

    @Test
    fun contexLoads() {
        assertThat(controller.greeting("takayuky").content).isEqualTo("Hello, takayuky!")
    }
}

