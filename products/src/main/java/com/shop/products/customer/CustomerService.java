package com.shop.products.customer;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
  private final CustomerRepository repo;

  private final CustomerMapper customerMapper;

  public CustomerService(CustomerRepository repo, CustomerMapper customerMapper) {
    this.repo = repo;
    this.customerMapper = customerMapper;
  }

  public CustomerResponseDto saveCustomer(CustomerDto dto){
    var cust = customerMapper.toCustomer(dto);
    var savedCustomer = repo.save(cust);
    return customerMapper.toCustomerRsponseDto(savedCustomer);
  }
  public List<CustomerResponseDto> findAllCustomers(){
    return repo.findAll().stream().map(customerMapper::toCustomerRsponseDto).collect(Collectors.toList());
  }
  public CustomerResponseDto findCustomersById(Integer id){

    return repo.findById(id).map(customerMapper::toCustomerRsponseDto).orElse(null);
  }

  public List<CustomerResponseDto> findCustomersByName(String name){
    return repo.findAllByFirstnameLike(name).stream().map(customerMapper::toCustomerRsponseDto).collect(Collectors.toList());
  }

  public void delete( Integer id){
    repo.deleteById(id);
  }
}
