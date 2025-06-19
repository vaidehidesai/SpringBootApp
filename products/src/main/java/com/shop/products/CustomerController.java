package com.shop.products;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

  private final CustomerRepository repo;


  public CustomerController(CustomerRepository repo) {
    this.repo = repo;
  }


  @PostMapping("/customers")
  public Customer post(@RequestBody Customer customer){
   return repo.save(customer);
  }

  @GetMapping("/customers")
  public List<Customer> findAllCustomers(){
    return repo.findAll();
  }

  @GetMapping("/customers/{cust-id}")
  public Customer findCustomersById(@PathVariable("cust-id") Integer id){
    return repo.findById(id).orElse(null);
  }

  @GetMapping("/customers/search/{cust-name}")
  public List<Customer> findCustomersByName(@PathVariable("cust-name") String name){
    return repo.findAllByFirstnameLike(name);
  }

  @DeleteMapping("/customers/{cust-id}")
  public void delete(@PathVariable("cust-id") Integer id){
    repo.deleteById(id);
  }

}
