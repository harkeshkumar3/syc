package com.syc.exception;


import feign.FeignException;
import jakarta.annotation.Priority;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
@Priority(2)
@Slf4j
public class GlobalExceptionHandler {

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody
    ExceptionResponse handleException(final Exception exception,
                                      final HttpServletRequest request) {

        log.info(exception.getMessage());
        log.error(exception.getMessage());
        exception.printStackTrace();
        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage(exception.getMessage());
        error.setRequestedURI(request.getRequestURI());
        error.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        error.setResponseTime(LocalDateTime.now());

        return error;
    }
}
