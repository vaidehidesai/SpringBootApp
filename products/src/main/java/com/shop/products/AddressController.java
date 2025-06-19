package com.shop.products;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {

  private final AddressRepository repo;

  public AddressController(AddressRepository repo) {
    this.repo = repo;
  }

  @PostMapping("/addresses")
  public Address post(@RequestBody Address address){
    return repo.save(address);
  }
  @GetMapping("/addresses")
  public List<Address> post(){
    return repo.findAll();
  }
}
