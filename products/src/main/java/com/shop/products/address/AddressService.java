package com.shop.products.address;

import com.shop.products.address.AddressDto;
import com.shop.products.address.AddressMapper;
import com.shop.products.address.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {
  private final AddressRepository repo;
  private final AddressMapper addressMapper;

  public AddressService(AddressRepository repo, AddressMapper addressMapper) {
    this.repo = repo;
    this.addressMapper = addressMapper;
  }

  public AddressDto post(AddressDto dto
  ){
    var address = addressMapper.toAddress(dto);
    repo.save(address);
    return dto;
  }

  public List<AddressDto> get(){
    return repo.findAll().stream().map(addressMapper::toAddressDto).collect(Collectors.toList());
  }

}
