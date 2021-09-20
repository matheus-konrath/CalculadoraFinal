package br.com.Compasso.calculadora.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import br.com.Compasso.calculadora.dto.DefaultErrorDto;
import br.com.Compasso.calculadora.dto.RecordNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(RecordNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public DefaultErrorDto notFound(RecordNotFoundException rec, WebRequest web) {
		DefaultErrorDto mensagem = new DefaultErrorDto(rec.getMessage());
		return mensagem;
	}
}