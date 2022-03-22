package com.cts.knowledgebasesystem.technologyservice.exceptions;

import com.cts.knowledgebasesystem.technologyservice.entities.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserDefinedExceptionHandler extends
        ResponseEntityExceptionHandler {

    @ExceptionHandler(TechnologyException.class)
    public ResponseEntity<ErrorMessage> technologyException(TechnologyException e, WebRequest request){
        ErrorMessage message = new ErrorMessage(HttpStatus.BAD_REQUEST,e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    @ExceptionHandler(TechNameNotFoundException.class)
    public ResponseEntity<ErrorMessage> techNameNotFoundException(TechNameNotFoundException e, WebRequest request){
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> systemException(Exception e, WebRequest request){
        ErrorMessage message = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
    }
}
