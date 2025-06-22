package com.shop.products.customer;

import com.shop.products.address.Address;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
  public Customer toCustomer(CustomerDto dto){
    var customer = new Customer();
    customer.setFirstname(dto.firstname());
    customer.setLastname(dto.lastname());
    customer.setEmail(dto.email());

    var address = new Address();
    address.setId(dto.addressId());

    customer.setAddress(address);

    return customer;

  }

  public CustomerResponseDto toCustomerRsponseDto(Customer customer){
    return new CustomerResponseDto(
            customer.getFirstname(), customer.getLastname(), customer.getEmail()
    );
  }
}
