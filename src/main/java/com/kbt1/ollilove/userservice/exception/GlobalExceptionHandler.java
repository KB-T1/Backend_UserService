package com.kbt1.ollilove.userservice.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    //@ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<ErrorResponse> handleException(Exception e) {
        final ErrorCode errorCode = ErrorCode.INTERNAL_SERVER_ERROR;
        final ErrorResponse response =
                ErrorResponse.builder()
                        .message(errorCode.getMsg())
                        .code(errorCode.getCode())
                        .build();

        return new ResponseEntity<>(response, HttpStatusCode.valueOf(errorCode.getStatus()));
    }

    @ExceptionHandler(BaseException.class)
    protected ResponseEntity<ErrorResponse> handleRuntimeException(BaseException e) {
        final ErrorCode errorCode = e.getErrorCode();
        final ErrorResponse response =
                ErrorResponse.builder()
                        .message(errorCode.getMsg())
                        .code(errorCode.getCode())
                        .build();

        return new ResponseEntity<>(response, HttpStatusCode.valueOf(errorCode.getStatus()));
    }


    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException e,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {
        ErrorCode errorCode = ErrorCode.INPUT_INVALID_VALUE;
        return handleExceptionInternal(errorCode, e.getMessage());
    }

    //@ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleAllException(Exception ex) {
        ErrorCode errorCode = ErrorCode.INTERNAL_SERVER_ERROR;
        return handleExceptionInternal(ex,errorCode);
    }

    private ResponseEntity<Object> handleExceptionInternal(Exception ex,ErrorCode errorCode) {
        return ResponseEntity.status(errorCode.getStatus())
                .body(makeErrorResponse(ex,errorCode));
    }

    private ErrorResponse makeErrorResponse(Exception ex,ErrorCode errorCode) {
        return ErrorResponse.builder()
                .code(errorCode.name())
                .message(ex.getMessage())
                .build();
    }

    private ResponseEntity<Object> handleExceptionInternal(ErrorCode errorCode, String message) {
        return ResponseEntity.status(errorCode.getStatus())
                .body(makeErrorResponse(errorCode, message));
    }

    private ErrorResponse makeErrorResponse(ErrorCode errorCode, String message) {
        return ErrorResponse.builder()
                .code(errorCode.name())
                .message(message)
                .build();
    }

//    private ResponseEntity<Object> handleExceptionInternal(BindException e, ErrorCode errorCode) {
//        return ResponseEntity.status(errorCode.getHttpStatus())
//                .body(makeErrorResponse(e, errorCode));
//    }
//
//    private ErrorResponse makeErrorResponse(BindException e, ErrorCode errorCode) {
//        List<ErrorResponse.ValidationError> validationErrorList = e.getBindingResult()
//                .getFieldErrors()
//                .stream()
//                .map(ErrorResponse.ValidationError::of)
//                .collect(Collectors.toList());
//
//        return ErrorResponse.builder()
//                .code(errorCode.name())
//                .message(errorCode.getMessage())
//                .errors(validationErrorList)
//                .build();
//    }
}


