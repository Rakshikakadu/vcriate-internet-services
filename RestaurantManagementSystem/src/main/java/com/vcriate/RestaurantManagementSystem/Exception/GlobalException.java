package com.vcriate.RestaurantManagementSystem.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<CustomizeErrorDetails> CustomerExceptionHandler(CustomerException e, WebRequest req) {
		CustomizeErrorDetails err = new CustomizeErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDescription(req.getDescription(false));

		return new ResponseEntity<CustomizeErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(MenuItemException.class)
	public ResponseEntity<CustomizeErrorDetails> MenuItemExceptionHandler(MenuItemException e, WebRequest req) {
		CustomizeErrorDetails err = new CustomizeErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDescription(req.getDescription(false));

		return new ResponseEntity<CustomizeErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(OrderException.class)
	public ResponseEntity<CustomizeErrorDetails> OrderExceptionHandler(OrderException e, WebRequest req) {
		CustomizeErrorDetails err = new CustomizeErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDescription(req.getDescription(false));

		return new ResponseEntity<CustomizeErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ReservationException.class)
	public ResponseEntity<CustomizeErrorDetails> ReservationExceptionHandler(ReservationException e, WebRequest req) {
		CustomizeErrorDetails err = new CustomizeErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDescription(req.getDescription(false));

		return new ResponseEntity<CustomizeErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(StaffException.class)
	public ResponseEntity<CustomizeErrorDetails> StaffExceptionHandler(StaffException e, WebRequest req) {
		CustomizeErrorDetails err = new CustomizeErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDescription(req.getDescription(false));

		return new ResponseEntity<CustomizeErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<CustomizeErrorDetails> UserExceptionHandler(UserException e, WebRequest req) {
		CustomizeErrorDetails err = new CustomizeErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDescription(req.getDescription(false));

		return new ResponseEntity<CustomizeErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<CustomizeErrorDetails> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException me,
			WebRequest re) {
		CustomizeErrorDetails err = new CustomizeErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(me.getBindingResult().getFieldError().getDefaultMessage());
		err.setDescription(re.getDescription(false));
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<CustomizeErrorDetails> noHandlerFoundExceptionHandler(NoHandlerFoundException e, WebRequest req) {

		CustomizeErrorDetails err = new CustomizeErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDescription(req.getDescription(false));

		return new ResponseEntity<CustomizeErrorDetails>(err, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<CustomizeErrorDetails> exceptionHandler(Exception me, WebRequest re) {
		CustomizeErrorDetails err = new CustomizeErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(me.getMessage());
		err.setDescription(re.getDescription(false));
		return new ResponseEntity<CustomizeErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

}
