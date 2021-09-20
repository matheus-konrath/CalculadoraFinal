package br.com.Compasso.calculadora.dto;

public class DefaultErrorDto {

	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public DefaultErrorDto(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}
	
	
}
