package com.syc.exception;


import jakarta.annotation.Priority;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
@Priority(1)
@Slf4j
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public ExceptionResponse MyFileNotFoundExceptionException(HttpServletRequest req, ResourceNotFoundException ex) {
        log.info("ExceptionHandler>>>>>>>>>>>>>>>>>>>>>>>>ResourceNotFoundException");
        log.info("Error message ={} and request header ={} ",ex.getMessage(),req.getRequestURI());
        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage(ex.getMessage());
        error.setRequestedURI(req.getRequestURI());
        error.setHttpStatus(HttpStatus.NOT_FOUND);
        error.setResponseTime(LocalDateTime.now());
        return error;
    }
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionResponse handlerBadCredentialsException(HttpServletRequest req, BadRequestException ex) {

        log.info("ExceptionHandler>>>>>>>>>>>>>>>>>>>>>>>>BadRequestException");
        log.info(ex.getMessage());
        ex.printStackTrace();
        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage(ex.getMessage());
        error.setRequestedURI(req.getRequestURI());
        error.setHttpStatus(HttpStatus.BAD_REQUEST);
        error.setResponseTime(LocalDateTime.now());

        return error;
    }
}
