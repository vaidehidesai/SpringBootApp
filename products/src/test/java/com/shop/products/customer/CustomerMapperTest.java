package com.shop.products.customer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerMapperTest {

  private CustomerMapper mapper;

  @BeforeEach
  void setUp() {
    mapper = new CustomerMapper();
  }

  @Test
  public void mapDtoToCustomer(){
    CustomerDto dto = new CustomerDto("Jethalal","Gada","gada@mail.com",2);

    Customer cust = mapper.toCustomer(dto);

    Assertions.assertEquals(dto.firstname(),cust.getFirstname());
    Assertions.assertEquals(dto.lastname(),cust.getLastname());
    Assertions.assertEquals(dto.email(),cust.getEmail());
    assertNotNull(cust.getAddress());
    Assertions.assertEquals(dto.addressId(),cust.getAddress().getId());
  }

  @Test
  public void throwExpWhenDtoIsNull(){
    assertThrows(NullPointerException.class,()->mapper.toCustomer(null));
  }

  @Test
  public void mapCustomerToDto(){
    Customer cust = new Customer("Daya","Gada","daya@gmail.com",34);

    CustomerResponseDto dto = mapper.toCustomerRsponseDto(cust);

    Assertions.assertEquals(cust.getFirstname(),dto.firstname());
    assertEquals(cust.getLastname(),dto.lastname());
    assertEquals(cust.getEmail(),dto.email());



  }
}