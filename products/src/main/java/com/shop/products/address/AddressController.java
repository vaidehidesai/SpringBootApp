package com.shop.products.address;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {

  private final AddressService addressService;

  public AddressController(AddressService addressService) {
    this.addressService = addressService;
  }

  @PostMapping("/addresses")
  public AddressDto post(
          @RequestBody AddressDto dto
  ){
    return addressService.post(dto);
  }



  @GetMapping("/addresses")
  public List<AddressDto> get(){
    return addressService.get();
  }
}
