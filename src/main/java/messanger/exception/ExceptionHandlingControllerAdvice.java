package messanger.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ResponseBody
@ControllerAdvice
public class ExceptionHandlingControllerAdvice {

    private static final String INCORRECT_INPUT_DATA = "Incorrect input data";
    private static final String ASSET_NOT_FOUND = "Entity not found";
    private static final String UNHANDLED_EXCEPTION = "Unhandled exception";

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public ApiErrorDto handleException(EntityNotFoundException ex) {
        log.info(ASSET_NOT_FOUND, ex);
        return getApiErrorDto(ex, NOT_FOUND);
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler({
            IllegalArgumentException.class,
            ConstraintViolationException.class
    })
    public ApiErrorDto handleException(RuntimeException ex) {
        log.info(INCORRECT_INPUT_DATA, ex);
        return getApiErrorDto(ex, BAD_REQUEST);
    }

    @ExceptionHandler
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ApiErrorDto handleException(Exception ex) {
        log.error(UNHANDLED_EXCEPTION, ex);
        return getApiErrorDto(ex, INTERNAL_SERVER_ERROR);
    }

    private ApiErrorDto getApiErrorDto(Exception ex, HttpStatus status) {
        return new ApiErrorDto(
                status.value(),
                status.getReasonPhrase(),
                ex.getClass().getSimpleName(),
                ex.getMessage());
    }
}
