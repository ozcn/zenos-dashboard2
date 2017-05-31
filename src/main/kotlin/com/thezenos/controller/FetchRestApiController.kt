package com.thezenos.controller

import com.thezenos.entity.Quote
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
class FetchRestApiController {
    inner class QuoteResponse(val id: Int, val quote: String)

    @RequestMapping("/quote")
    fun fetchAndShowQuote(@RequestParam(value = "num", defaultValue = "1") num: Int): List<QuoteResponse> {
        val responses =
          if (num <= 0) emptyList()
          else {
            val restTemplate = RestTemplate()
            (1..num).map {
                val quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote::class.java)
                QuoteResponse(it, quote.value.quote)
            }
          }
        return responses
    }
}
