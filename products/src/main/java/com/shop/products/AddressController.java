package com.shop.products;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AddressController {

  private final AddressRepository repo;

  public AddressController(AddressRepository repo) {
    this.repo = repo;
  }

  @PostMapping("/addresses")
  public AddressDto post(
          @RequestBody AddressDto dto
  ){
    var address = toAddress(dto);
    repo.save(address);
    return dto;
  }

  private Address toAddress(AddressDto dto) {
    return new Address(dto.name());
  }

  private AddressDto toAddressDto(Address address){
    return new AddressDto(address.getName());
  }

  @GetMapping("/addresses")
  public List<AddressDto> post(){
    return repo.findAll().stream().map(this::toAddressDto).collect(Collectors.toList());
  }
}
