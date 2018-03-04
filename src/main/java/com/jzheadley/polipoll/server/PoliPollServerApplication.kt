package com.jzheadley.polipoll.server

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
open class PoliPollServerApplication

fun main(args: Array<String>) {
    SpringApplication.run(PoliPollServerApplication::class.java, *args)
}

