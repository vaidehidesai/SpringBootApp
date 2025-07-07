package com.shop.products.customer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class CustomerServiceTest {
  @InjectMocks
  private CustomerService customerService;
  @Mock
  private CustomerRepository repo;
  @Mock
  private CustomerMapper customerMapper;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void saveStudentTest(){
    Customer cust = new Customer("Daya","Gada","daya@gmail.com",34);
    CustomerDto dto = new CustomerDto("Daya","Gada","daya@gmail.com",2);

    Mockito.when(customerMapper.toCustomer(dto)).thenReturn(cust);
    Mockito.when(repo.save(cust)).thenReturn(cust);
    Mockito.when(customerMapper.toCustomerRsponseDto(cust)).thenReturn(new CustomerResponseDto("Daya","Gada","daya@gmail.com"));

    CustomerResponseDto respDto = customerService.saveCustomer(dto);

    assertEquals(respDto.firstname(),dto.firstname());
    assertEquals(respDto.lastname(),dto.lastname());
    assertEquals(respDto.email(),dto.email());

  }

  @Test
  public void findAllCustomersTest(){
    List<Customer> customers = new ArrayList<>();

    customers.add(new Customer("Daya","Gada","daya@gmail.com",34));

    Mockito.when(repo.findAll()).thenReturn(customers);
    Mockito.when(customerMapper.toCustomerRsponseDto(any(Customer.class))).thenReturn(new CustomerResponseDto("Daya","Gada","daya@gmail.com"));

    List<CustomerResponseDto> custRespDto = customerService.findAllCustomers();

    assertEquals(custRespDto.size(),customers.size());

    Mockito.verify(repo,Mockito.times(1)).findAll();
  }

  @Test
  public void findCustomersByIdTest(){

    Integer id =2;

    Customer cust = new Customer("Daya","Gada","daya@gmail.com",34);

    Mockito.when(repo.findById(id)).thenReturn(Optional.of(cust));

    Mockito.when(customerMapper.toCustomerRsponseDto(cust)).thenReturn(new CustomerResponseDto("Daya","Gada","daya@gmail.com"));

    CustomerResponseDto respDto = customerService.findCustomersById(id);

    Assertions.assertEquals(respDto.firstname(),cust.getFirstname());
    Assertions.assertEquals(respDto.lastname(),cust.getLastname());
    Assertions.assertEquals(respDto.email(),cust.getEmail());

    Mockito.verify(repo,Mockito.times(1)).findById(id);

  }

  @Test
  public void findCustomersByNameTest(){
    List<Customer> customers = new ArrayList<>();
    String name = "Daya";

    customers.add(new Customer("Daya","Gada","daya@gmail.com",34));

    Mockito.when(repo.findAllByFirstnameLike(name)).thenReturn(customers);
    Mockito.when(customerMapper.toCustomerRsponseDto(any(Customer.class))).thenReturn(new CustomerResponseDto("Daya","Gada","daya@gmail.com"));

    List<CustomerResponseDto> custRespDto = customerService.findCustomersByName(name);

    assertEquals(custRespDto.size(),customers.size());

    Mockito.verify(repo,Mockito.times(1)).findAllByFirstnameLike(name);

  }

}