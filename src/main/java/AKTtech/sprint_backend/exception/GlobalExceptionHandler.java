package AKTtech.sprint_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handleRuntimeException(RuntimeException ex) {
        Map<String, Object> erreur = new HashMap<>();
        erreur.put("timestamp", LocalDateTime.now());
        erreur.put("status", HttpStatus.BAD_REQUEST.value());
        erreur.put("message", ex.getMessage());
        return new ResponseEntity<>(erreur, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationException(
            org.springframework.web.bind.MethodArgumentNotValidException ex) {
        Map<String, Object> erreur = new HashMap<>();
        erreur.put("timestamp", LocalDateTime.now());
        erreur.put("status", HttpStatus.BAD_REQUEST.value());

        Map<String, String> champsErreurs = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                champsErreurs.put(error.getField(), error.getDefaultMessage())
        );
        erreur.put("erreurs", champsErreurs);

        return new ResponseEntity<>(erreur, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleException(Exception ex) {
        Map<String, Object> erreur = new HashMap<>();
        erreur.put("timestamp", LocalDateTime.now());
        erreur.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        erreur.put("message", "Erreur interne du serveur");
        return new ResponseEntity<>(erreur, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}