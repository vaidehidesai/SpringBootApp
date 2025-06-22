package com.shop.products.address;

import com.shop.products.address.AddressDto;
import org.springframework.stereotype.Service;

@Service
public class AddressMapper {

  public Address toAddress(AddressDto dto) {
    return new Address(dto.name());
  }

  public AddressDto toAddressDto(Address address){
    return new AddressDto(address.getName());
  }
}
