package com.edu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	
    @ExceptionHandler(CustomException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<ResponseMessage> handleCustomException(CustomException ex) {
    	
    	ResponseMessage error = new ResponseMessage("Custom Exception: " + ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        		
    }

    // Add more exception handlers as needed
    
    
    // for validation 
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseMessage> handleValidationExceptions(
      MethodArgumentNotValidException ex) {
    	StringBuilder finalErrorMessage = new StringBuilder();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
        	 String fieldName = ((FieldError) error).getField();
             String errorMessage = error.getDefaultMessage();
             finalErrorMessage.append(fieldName).append("-->").append(errorMessage+"  ");
             System.out.println(finalErrorMessage);
        });
        
     
        
        
        ResponseMessage error = new ResponseMessage("Validation Exception: " + finalErrorMessage);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}