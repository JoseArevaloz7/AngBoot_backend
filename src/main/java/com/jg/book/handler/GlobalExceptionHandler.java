package com.jg.book.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.LockedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LockedException.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception e){
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(ExceptionResponse.builder()
                        .busisnesErrorCode(BusisnessErrorCodes.ACCOUNT_LOCKED.getCode())
                        .busisnesExceptionDescription(BusisnessErrorCodes.ACCOUNT_LOCKED.getDescription())
                        .error(e.getMessage())
                        .build());
    }
}
