package com.github.seif.apirest.advice;

import com.github.seif.apirest.error.ApiError;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private ApiError build(WebRequest req, HttpStatus st, String msg) {
        return new ApiError(Instant.now(), st.value(), st.getReasonPhrase(),
                msg, ((ServletWebRequest) req).getRequest().getRequestURI());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiError> notFound(EntityNotFoundException ex, WebRequest req) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(build(req, HttpStatus.NOT_FOUND, ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> validation(MethodArgumentNotValidException ex, WebRequest req) {
        FieldError fe = ex.getBindingResult().getFieldError();
        return ResponseEntity.badRequest()
                .body(build(req, HttpStatus.BAD_REQUEST,
                        fe != null ? fe.getDefaultMessage() : ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> generic(Exception ex, WebRequest req) {
        return ResponseEntity.internalServerError()
                .body(build(req, HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()));
    }
}
