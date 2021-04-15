package com.myapp.candles

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EntityScan("com.myapp.candles.entities")
@EnableJpaRepositories("com.myapp.candles.repositories")
class CandlesApplication

fun main(args: Array<String>) {
    runApplication<CandlesApplication>(*args)
}
