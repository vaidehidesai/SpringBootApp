package com.shop.products.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

  List<Customer> findAllByFirstnameLike(String firstname);
}
