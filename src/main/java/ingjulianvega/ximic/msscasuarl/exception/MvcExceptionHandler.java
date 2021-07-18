package ingjulianvega.ximic.msscasuarl.exception;

import ingjulianvega.ximic.msscasuarl.configuration.ArlParameters;
import ingjulianvega.ximic.msscasuarl.configuration.ErrorCodeMessages;
import ingjulianvega.ximic.msscasuarl.exception.ArlException;
import ingjulianvega.ximic.msscasuarl.web.model.ApiError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MvcExceptionHandler extends ResponseEntityExceptionHandler {
    private final ArlParameters arlParameters;

    public MvcExceptionHandler(ArlParameters arlParameters) {
        this.arlParameters = arlParameters;
    }

    @ExceptionHandler(ArlException.class)
    public ResponseEntity<ApiError> validationErrorHandler(ArlException pe) {
        ApiError apiError = ApiError
                .builder()
                .timestamp(LocalDateTime.now())
                .api(arlParameters.getApi())
                .apiCode(pe.getApiCode())
                .error(pe.getError())
                .message(pe.getMessage())
                .solution(pe.getSolution())
                .build();
         return new ResponseEntity<>(apiError, pe.getHttpStatus());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        ApiError apiError = ApiError
                .builder()
                .timestamp(LocalDateTime.now())
                .api(arlParameters.getApi())
                .apiCode(ErrorCodeMessages.ARGUMENT_NOT_VALID_API_CODE)
                .error(ErrorCodeMessages.ARGUMENT_NOT_VALID_ERROR)
                .message(errors.toString())
                .solution(ErrorCodeMessages.ARGUMENT_NOT_VALID_SOLUTION)
                .build();

        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
}