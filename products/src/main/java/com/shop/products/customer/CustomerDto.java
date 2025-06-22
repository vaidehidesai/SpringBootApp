package com.shop.products.customer;

import jakarta.validation.constraints.NotEmpty;

public record CustomerDto(
        @NotEmpty(message = "firstname cannot be empty")
        String firstname,
        @NotEmpty
        String lastname,
        String email,
        Integer addressId
) {

}
