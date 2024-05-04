package com.pede.ai.infra.commons.handlers;

import com.pede.ai.core.exceptions.CommitException;
import com.pede.ai.infra.commons.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> globalExceptionHandler(
            Exception exception,
            WebRequest webRequest
    ) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage(exception.getMessage());
        errorMessage.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        errorMessage.setThrownAt(LocalDateTime.now());

        return ResponseEntity.status(errorMessage.getHttpStatus().value()).body(errorMessage);
    }

    @ExceptionHandler(CommitException.class)
    public ResponseEntity<ErrorMessage> commitExceptionHandler(
            CommitException exception,
            WebRequest webRequest
    ) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage(exception.getMessage());
        errorMessage.setHttpStatus(HttpStatus.BAD_REQUEST);
        errorMessage.setThrownAt(LocalDateTime.now());

        return ResponseEntity.status(errorMessage.getHttpStatus().value()).body(errorMessage);
    }
}
