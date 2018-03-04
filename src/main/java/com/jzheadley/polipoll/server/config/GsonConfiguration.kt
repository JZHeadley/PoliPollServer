package com.jzheadley.polipoll.server.config

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.springframework.context.annotation.Bean

class GsonConfiguration {
    @Bean
    fun create(): Gson {
        return GsonBuilder().setPrettyPrinting().create()
    }
}