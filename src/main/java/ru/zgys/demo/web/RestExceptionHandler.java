package ru.zgys.demo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.zgys.demo.exception.PersonNotFoundException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * @author U.Goryntsev 30.08.2017
 */
@ControllerAdvice
public class RestExceptionHandler {
	private static final Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);

	@ExceptionHandler(PersonNotFoundException.class)
	public ResponseEntity<?> handleNotFoundException(PersonNotFoundException e) {
		return errorResponse(e, NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGenericException(Exception e) {
		return errorResponse(e, INTERNAL_SERVER_ERROR);
	}

	private ResponseEntity<?> errorResponse(Throwable e, HttpStatus status) {
		log.warn("rest handled {}: {}, status '{}'", e.getClass().getSimpleName(), e.getMessage(), status.toString());
		log.debug("stacktrace", e);
		return errorResponse(e.getClass().getSimpleName(), e.getMessage(), status);
	}

	private ResponseEntity<?> errorResponse(String error, String message, HttpStatus status) {
		ResponseEntity.BodyBuilder builder = ResponseEntity
				.status(status)
				.header("X-Error", error);
		if (message != null) {
			builder.header("X-Error-Message", message);
		}
		return builder.build();
	}
}
