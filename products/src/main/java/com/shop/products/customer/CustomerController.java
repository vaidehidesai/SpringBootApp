package com.shop.products.customer;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class CustomerController {
  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  private final CustomerService customerService;

  @PostMapping("/customers")
  public CustomerResponseDto saveCustomer(@Valid @RequestBody CustomerDto dto){
      return customerService.saveCustomer(dto);
  }

  @GetMapping("/customers")
  public List<CustomerResponseDto> findAllCustomers(){
    return customerService.findAllCustomers();
  }

  @GetMapping("/customers/{cust-id}")
  public CustomerResponseDto findCustomersById(@PathVariable("cust-id") Integer id){

    return customerService.findCustomersById(id);
  }

  @GetMapping("/customers/search/{cust-name}")
  public List<CustomerResponseDto> findCustomersByName(@PathVariable("cust-name") String name){
    return customerService.findCustomersByName(name);
  }

  @DeleteMapping("/customers/{cust-id}")
  public void delete(@PathVariable("cust-id") Integer id){
    customerService.delete(id);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exp){
    var errors = new HashMap<String,String>();

    exp.getBindingResult().getAllErrors().forEach(error ->{
      var fieldName = ((FieldError)error).getField();
      var message = error.getDefaultMessage();
      errors.put(fieldName,message);
    });

    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
  }

}
