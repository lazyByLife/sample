package com.lazybylife.sample

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorld {

    @GetMapping("/{name}")
    fun helloWorld(@PathVariable name: String,
                   @RequestBody greeting: String,
                   @RequestParam etc: String) : String {

        return "$greeting $name $etc"
    }
}