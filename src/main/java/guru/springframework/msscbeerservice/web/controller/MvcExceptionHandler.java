package guru.springframework.msscbeerservice.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class MvcExceptionHandler {

    @ExceptionHandler(BindException.class)
    public ResponseEntity<List> validationErrorHandler(BindException ex) {

        List<Object> errorsList = new ArrayList<>(ex.getErrorCount());
        ex.getAllErrors().forEach(error -> {
            errorsList.add(error.toString());
        });

        return new ResponseEntity<>(errorsList, HttpStatus.BAD_REQUEST);
    }

}
