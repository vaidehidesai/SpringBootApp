package com.vaidehi.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
  @GetMapping("/hello")
  public String sayHi(){
    return "HIIIII";
  }
}
