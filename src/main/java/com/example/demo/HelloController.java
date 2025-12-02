package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping("/")
  public String home() {
    return "Hello from Demo Spring Boot app!";
  }

  @GetMapping("/greet")
  public String greet(@RequestParam(name = "name", defaultValue = "World") String name) {
    return "Hello, " + name + "!";
  }
}