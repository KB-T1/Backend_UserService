//package com.kbt1.ollilove.userservice.exception;
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.HttpRequestMethodNotSupportedException;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//@RestControllerAdvice
//public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
//    @Override
//    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
//            HttpRequestMethodNotSupportedException ex
//            , HttpHeaders headers
//            , HttpStatus status
//            , WebRequest request
//    ) {
//        return new BaseException("EX003", "HttpRequestMethodNotSupportedException occurred");
//    }
//}
