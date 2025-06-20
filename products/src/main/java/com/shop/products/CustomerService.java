package com.shop.products;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

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
  public List<Customer> findAllCustomers(){
    return repo.findAll();
  }
  public Customer findCustomersById(Integer id){

    return repo.findById(id).orElse(null);
  }

  public List<Customer> findCustomersByName(String name){
    return repo.findAllByFirstnameLike(name);
  }

  public void delete( Integer id){
    repo.deleteById(id);
  }
}
