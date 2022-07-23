package com.timal1.spring.web.cart.exeptions;

public class CartIsBrokenException extends RuntimeException{
    CartIsBrokenException(String message) {
        super(message);
    }
}
