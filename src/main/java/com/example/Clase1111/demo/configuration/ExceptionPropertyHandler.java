package com.example.Clase1111.demo.configuration;

import com.example.Clase1111.demo.controller.nonexistentClientException;
import com.example.Clase1111.demo.controller.nonexistentPropertyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionPropertyHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({nonexistentPropertyException.class})
    protected ResponseEntity<Object> handleNotFound(
            Exception ex, WebRequest request){
        return handleExceptionInternal(ex,"Property not found",
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
