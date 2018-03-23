package tech.diggle.apps.limasmart

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class LimaSmartApplication

fun main(args: Array<String>) {
    SpringApplication.run(LimaSmartApplication::class.java, *args)
}
