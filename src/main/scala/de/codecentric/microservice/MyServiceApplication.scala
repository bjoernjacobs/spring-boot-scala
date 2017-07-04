package de.codecentric.microservice

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

object MyServiceApplication {
  def main(args: Array[String]) : Unit = SpringApplication.run(classOf[MyServiceApplication], args :_ *)
}

@SpringBootApplication
class MyServiceApplication {}
