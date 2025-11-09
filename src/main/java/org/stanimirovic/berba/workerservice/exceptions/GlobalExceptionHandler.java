package org.stanimirovic.berba.workerservice.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> errors.put(error.getObjectName(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, String>> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        Map<String, String> errors = new HashMap<>();
        log.warn("Duplicate entity error: {}", ex.getMessage());
        errors.put("message", "Worker with this phone number or email address already exists");
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(WorkerNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleWorkerNotFoundException(WorkerNotFoundException ex) {
        Map<String, String> errors = new HashMap<>();
        log.warn("Worker not found: {}", ex.getMessage());
        errors.put("message", ex.getMessage());
        return ResponseEntity.badRequest().body(errors);
    }

//    @ExceptionHandler(WorkerActivityNotFoundException.class)
//    public ResponseEntity<Map<String, String>> handleWorkerActivityNotFoundException(WorkerActivityNotFoundException ex) {
//        Map<String, String> errors = new HashMap<>();
//        log.warn("Worker activity not found: {}", ex.getMessage());
//        errors.put("message", ex.getMessage());
//        return ResponseEntity.badRequest().body(errors);
//    }

//    @ExceptionHandler(WorkerNotAssociatedWithActivityException.class)
//    public ResponseEntity<Map<String, String>> handleWorkerNotAssociatedWithActivityException(WorkerNotAssociatedWithActivityException ex) {
//        Map<String, String> errors = new HashMap<>();
//        log.warn("Worker not associated with activity: {}", ex.getMessage());
//        errors.put("message", ex.getMessage());
//        return ResponseEntity.badRequest().body(errors);
//    }

    @ExceptionHandler(WorkerNotAssociatedWithUserException.class)
    public ResponseEntity<Map<String, String>> handleWorkerNotAssociatedWithUserException(WorkerNotAssociatedWithUserException ex) {
        Map<String, String> errors = new HashMap<>();
        log.warn("Worker not associated with user: {}", ex.getMessage());
        errors.put("message", ex.getMessage());
        return ResponseEntity.badRequest().body(errors);
    }
}
