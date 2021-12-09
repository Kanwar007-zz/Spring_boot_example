
package com.kanwar.study.restapi.exceptionHandle;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizeResponseEntity extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception exception, WebRequest request) {
        ExceptionResponse exception1 = new ExceptionResponse(new Date(), exception.getMessage(), request.getDescription(false));
               
        return new ResponseEntity( exception1, HttpStatus.SERVICE_UNAVAILABLE);
    }
    @ExceptionHandler(UserNotException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(Exception exception, WebRequest request) {
        ExceptionResponse exception1 = new ExceptionResponse(new Date(), exception.getMessage(), request.getDescription(false));
               
        return new ResponseEntity( exception1, HttpStatus.SERVICE_UNAVAILABLE);
    }

}