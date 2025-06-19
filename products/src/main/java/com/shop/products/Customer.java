package com.shop.products;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name="c_table")
public class Customer {
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Id
  @GeneratedValue
  private Integer id;

  private String firstname;
  private String lastname;

  @Column(unique = true)
  private String email;

  private int age;

  @OneToOne(
          mappedBy = "customer",
          cascade = CascadeType.ALL
  )
  private CustomerProfile customerProfile;

  @ManyToOne
  @JoinColumn(name = "address_id")
  @JsonBackReference
  private Address address;

  public CustomerProfile getCustomerProfile() {
    return customerProfile;
  }

  public void setCustomerProfile(CustomerProfile customerProfile) {
    this.customerProfile = customerProfile;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public Customer() {
  }

  public Customer(String firstname, String lastname, String email, int age) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.age = age;
  }

  @Override
  public String toString() {
    return "Customer{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", email='" + email + '\'' +
            ", age=" + age +
            '}';
  }
}
