package com.shop.products;

public record CustomerDto(
        String firstname,
        String lastname,
        String email,
        Integer addressId
) {

}
