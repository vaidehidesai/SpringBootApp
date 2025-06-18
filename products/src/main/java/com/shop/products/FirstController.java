package com.shop.products;

import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {

  @PostMapping("/post-order")
  public String post(@RequestBody Order order){
    return "order is : "+order.toString();
  }

  @GetMapping("/hello/{user}")
  public String pathVar(@PathVariable("user") String username){
    return "username is : "+username;
  }

}
