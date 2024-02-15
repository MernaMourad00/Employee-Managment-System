package com.example.EmployeeManagmentSystem.exception;

import com.example.EmployeeManagmentSystem.web.response.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {EmployeeException.class})
    ResponseEntity<Object> handleApiException(EmployeeException e){
        ResponseModel responseModel = ResponseModel.builder().message(e.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .build();
        return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
    }

}
