package br.com.cezarcruz.lojaweb.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<StandardError> handleBusinessException(final Exception ex, final HttpServletRequest request) {

        log.error("error int ur {}", request.getRequestURI() );
        log.error("handling product not found exception", ex);

        final var standardError
                = StandardError.builder().code(HttpStatus.NOT_FOUND.value()).message(ex.getMessage()).build();

        return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(standardError);
    }

}
