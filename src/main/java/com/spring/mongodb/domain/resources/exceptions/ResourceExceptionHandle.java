package com.spring.mongodb.domain.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.mongodb.domain.service.exception.NotFoundException;

@ControllerAdvice
public class ResourceExceptionHandle {
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(NotFoundException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError erro = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(erro);
	}
	

}
