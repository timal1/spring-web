package com.timal1.spring.web.api.exeptions;

import com.timal1.spring.web.api.exeptions.AppError;

public class CartServiceAppError extends AppError {
    public CartServiceAppError(String code, String message) {
        super(code, message);
    }

    public enum CartServiceErrors {
        CART_IS_BROKEN, CART_ID_GENERATOR_DISABLED, CART_NOT_FOUND
    }
}
