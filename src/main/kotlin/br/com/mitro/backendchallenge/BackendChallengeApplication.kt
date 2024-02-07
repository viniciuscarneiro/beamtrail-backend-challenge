package br.com.mitro.backendchallenge

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class BackendChallengeApplication

fun main(args: Array<String>) {
	runApplication<BackendChallengeApplication>(*args)
}
