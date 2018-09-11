package jwright.bluebik;

import jwright.bluebik.exception.InvalidURLException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UrlShortenExceptionHandler {

    @ExceptionHandler(InvalidURLException.class)
    protected ResponseEntity<Object> handleInvalidUrl() {
        String bodyOfResponse = "The Provided URL is Invalid";
        return ResponseEntity.badRequest().body(bodyOfResponse);
    }
}
