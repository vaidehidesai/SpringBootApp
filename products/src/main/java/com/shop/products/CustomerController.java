package com.shop.products;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  private final CustomerService customerService;

  @PostMapping("/customers")
  public CustomerResponseDto saveCustomer(@RequestBody CustomerDto dto){
      return customerService.saveCustomer(dto);
  }

  @GetMapping("/customers")
  public List<Customer> findAllCustomers(){
    return customerService.findAllCustomers();
  }

  @GetMapping("/customers/{cust-id}")
  public Customer findCustomersById(@PathVariable("cust-id") Integer id){

    return customerService.findCustomersById(id);
  }

  @GetMapping("/customers/search/{cust-name}")
  public List<Customer> findCustomersByName(@PathVariable("cust-name") String name){
    return customerService.findCustomersByName(name);
  }

  @DeleteMapping("/customers/{cust-id}")
  public void delete(@PathVariable("cust-id") Integer id){
    customerService.delete(id);
  }

}
