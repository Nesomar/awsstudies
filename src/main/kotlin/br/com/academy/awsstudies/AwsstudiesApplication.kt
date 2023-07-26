package br.com.academy.awsstudies

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class AwsstudiesApplication

fun main(args: Array<String>) {
	runApplication<AwsstudiesApplication>(*args)
}
