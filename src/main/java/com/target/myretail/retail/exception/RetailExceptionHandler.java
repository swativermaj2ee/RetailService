package com.target.myretail.retail.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RetailExceptionHandler {
    @ExceptionHandler
    public ResponseEntity updateFailedExceptionHandler(UpdateFailedException excp) {
        ApiError apiError = new ApiError(HttpStatus.NOT_MODIFIED, excp);
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler
    public ResponseEntity resourceNotFoundExceptionHandler(ResourseNotFoundException excp) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, excp);
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler
    public ResponseEntity genericExceptionHandler(Exception excp) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, excp);
        return buildResponseEntity(apiError);
    }
    @ExceptionHandler
    public ResponseEntity  jsonProcessingExceptionHandler(JsonProcessingException excp) {
        ApiError apiError = new ApiError(HttpStatus.UNSUPPORTED_MEDIA_TYPE, excp);
        return buildResponseEntity(apiError);
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

}
