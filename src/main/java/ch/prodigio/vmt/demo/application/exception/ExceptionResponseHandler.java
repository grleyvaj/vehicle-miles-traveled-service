package ch.prodigio.vmt.demo.application.exception;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Gloria R. Leyva Jerez
 * Create responses to handle exceptions thrown in the system
 */
@RestControllerAdvice
@RequiredArgsConstructor
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ExceptionResponseHandler {

	private static final Logger LOG = LoggerFactory.getLogger(ExceptionResponseHandler.class);

	private static final int ERROR_CODE_ResourceNotFoundException = 1;
	private static final int ERROR_CODE_ConstraintViolationException_MODEL = 2;
	private static final int ERROR_CODE_InternalError_MODEL = 3;
	private static final int ERROR_CODE_MissingRequestHeaderException = 4;
	private static final int ERROR_CODE_CSVException = 5;

	private final ErrorContentHandler contentHandler;

	/**
	 * Create response to handle an exception thrown by empty content
	 *
	 * @param request HttpServletRequest Information for create a response to this exception
	 * @return ResponseEntity The response created
	 */
	@ExceptionHandler(MissingRequestHeaderException.class)
	@ApiResponse(responseCode = "400", description = Constants.incompletePtmError_resp_description,
		content = @Content(
			mediaType = MediaType.APPLICATION_JSON_VALUE,
			schema = @Schema(implementation = ErrorInfo.class), examples = {
			@ExampleObject(name = Constants.incompletePtmError_resp_name, summary = "400 from the service directly")}))
	public ResponseEntity<ErrorInfo> contentError(HttpServletRequest request, MissingRequestHeaderException e) {

		HttpStatus status = HttpStatus.BAD_REQUEST;
		String errorMessage = e.getMessage();
		ErrorInfo errorInfo = new ErrorInfo(
			request.getRequestURI(),
			request.getMethod(),
			errorMessage,
			status.getReasonPhrase(),
			status.value(),
			ERROR_CODE_MissingRequestHeaderException,
			"MissingRequestHeaderException"
		);

		return new ResponseEntity<>(errorInfo, contentHandler.notMethodArgumentTypeAlert(errorMessage), status);
	}

	/**
	 * Create response to handle an exception thrown by resource not found
	 *
	 * @param e ResourceNotFoundException Information for create a response to this exception
	 * @return ResponseEntity The response created
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	@ApiResponse(responseCode = "404", description = Constants.notFound_resp_description,
		content = @Content(
			mediaType = MediaType.APPLICATION_JSON_VALUE,
			schema = @Schema(implementation = ErrorInfo.class), examples = {
			@ExampleObject(name = Constants.notFound_resp_name, summary = "404 from the service directly")}))
	public ResponseEntity<ErrorInfo> notFound(HttpServletRequest request, ResourceNotFoundException e) {

		HttpStatus status = HttpStatus.NOT_FOUND;
		String errorMessage = contentHandler.notFoundAlertMessage(
			e.getResourceName(),
			e.getFieldName(),
			String.valueOf(e.getFieldValue())
		);
		ErrorInfo errorInfo = new ErrorInfo(
			request.getRequestURI(),
			request.getMethod(),
			errorMessage,
			status.getReasonPhrase(),
			status.value(),
			ERROR_CODE_ResourceNotFoundException,
			"ResourceNotFoundException"
		);

		return new ResponseEntity<>(errorInfo, contentHandler.notFoundAlert(errorMessage), status);
	}

	@ExceptionHandler(HttpServerErrorException.class)
	@ApiResponse(responseCode = "500", description = Constants.internalError_resp_description,
		content = @Content(
			mediaType = MediaType.APPLICATION_JSON_VALUE,
			schema = @Schema(implementation = ErrorInfo.class), examples = {
			@ExampleObject(name = Constants.internalError_resp_name, summary = "500 from the service directly")}))
	public ResponseEntity<ErrorInfo> internalError(HttpServletRequest request, HttpServerErrorException ex) {

		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		String errorMessage = ex.getMessage();
		ErrorInfo errorInfo = new ErrorInfo(
			request.getRequestURI(),
			request.getMethod(),
			errorMessage,
			status.getReasonPhrase(),
			status.value(),
			ERROR_CODE_InternalError_MODEL,
			"HttpServerErrorException"
		);

		return new ResponseEntity<>(errorInfo, contentHandler.notReadableAlert(errorMessage), status);
	}

	/**
	 * Create response to handle an exception thrown by constraint violation in validation DTO process
	 *
	 * @param ex ConstraintViolationException Information for create a response to this exception
	 * @return ResponseEntity The response created
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorInfo> methodValidationViolationConstraintHandler(
		HttpServletRequest request, MethodArgumentNotValidException ex
	) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError)error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});

		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
		String errorMessage = contentHandler.validationInModelAlertMessage(errors.toString());
		ErrorInfo errorInfo = new ErrorInfo(
			request.getRequestURI(),
			request.getMethod(),
			errorMessage,
			status.getReasonPhrase(),
			status.value(),
			ERROR_CODE_ConstraintViolationException_MODEL,
			"ConstraintViolationException-javax-validation"
		);

		return new ResponseEntity<>(errorInfo, contentHandler.validationInModelAlert(errorMessage), status);
	}

	/**
	 * Create response to handle an exception thrown by csv exceptions
	 *
	 * @param request ReadingCSVException Information for create a response to this exception
	 * @return ResponseEntity The response created
	 */
	@ExceptionHandler(FileCsvErrorException.class)
	@ApiResponse(responseCode = "400", description = Constants.csvExceptionError_resp_description,
		content = @Content(
			mediaType = MediaType.APPLICATION_JSON_VALUE,
			schema = @Schema(implementation = ErrorInfo.class), examples = {
			@ExampleObject(name = Constants.csvExceptionError_resp_name, summary = "400 from the service directly")}))
	public ResponseEntity<ErrorInfo> contentError(HttpServletRequest request, FileCsvErrorException e) {

		HttpStatus status = HttpStatus.BAD_REQUEST;
		String errorMessage = e.getMessage();
		ErrorInfo errorInfo = new ErrorInfo(
			request.getRequestURI(),
			request.getMethod(),
			errorMessage,
			status.getReasonPhrase(),
			status.value(),
			ERROR_CODE_CSVException,
			"MissingRequestHeaderException"
		);

		return new ResponseEntity<>(errorInfo, contentHandler.notMethodArgumentTypeAlert(errorMessage), status);
	}

//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public Map<String, String> handleValidationExceptions(
//		MethodArgumentNotValidException ex
//	) {
//		Map<String, String> errors = new HashMap<>();
//		ex.getBindingResult().getAllErrors().forEach((error) -> {
//			String fieldName = ((FieldError)error).getField();
//			String errorMessage = error.getDefaultMessage();
//			errors.put(fieldName, errorMessage);
//		});
//		return errors;
//	}

}

