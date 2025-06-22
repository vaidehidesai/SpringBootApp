package com.shop.products.customerprofile;

import com.shop.products.customer.Customer;
import jakarta.persistence.*;

@Entity
public class CustomerProfile {

  @Id
  @GeneratedValue
  private Integer id;

  private String bio;
  @OneToOne
  @JoinColumn(name = "student_id")
  private Customer customer;

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public CustomerProfile() {
  }

  public CustomerProfile(String bio) {
    this.bio = bio;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }
}
