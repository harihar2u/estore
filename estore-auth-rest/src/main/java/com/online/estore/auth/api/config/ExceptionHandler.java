package com.online.estore.auth.api.config;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

//    @org.springframework.web.bind.annotation.ExceptionHandler(value = {UsernameNotFoundException.class})
//    protected ResponseEntity<Object> handleException(RuntimeException ex, WebRequest request) {
//        String bodyOfResponse = "Username/password not valid!!";
//        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.FORBIDDEN, request);
//    }
}
