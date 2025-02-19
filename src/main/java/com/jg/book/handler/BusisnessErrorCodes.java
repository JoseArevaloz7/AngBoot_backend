package com.jg.book.handler;

import org.springframework.http.HttpStatus;

import lombok.Getter;

public enum BusisnessErrorCodes {
    NO_CODE(0, "No code", HttpStatus.INTERNAL_SERVER_ERROR),
    USER_ALREADY_EXISTS(1, "User already exists", HttpStatus.BAD_REQUEST),
    ACCOUNT_LOCKED(302, "Account locked", HttpStatus.FORBIDDEN),
    INCORRECT_CURRENT_PASSWORD(300, "Incorrect current password", HttpStatus.BAD_REQUEST),
    NEW_PASSWORD_DOES_NOT_MATCH(303, "New password does not match", HttpStatus.FORBIDDEN),
    ACCOUNT_DISABLED(304, "Account disabled", HttpStatus.FORBIDDEN),
    BAD_CREDENTIALS(305, "Login and / or password incorrect", HttpStatus.FORBIDDEN),

    ;
    @Getter
    private int code;
    @Getter
    private String description;
    @Getter
    private HttpStatus httpStatus;

    BusisnessErrorCodes(int code, String description, HttpStatus httpStatus) {
        this.code = code;
        this.description = description;
        this.httpStatus = httpStatus;
    }

}
