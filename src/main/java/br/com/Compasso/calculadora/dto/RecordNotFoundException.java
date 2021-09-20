package br.com.Compasso.calculadora.dto;




public class RecordNotFoundException extends RuntimeException {

	private static final Long serialVersionUID = 1l;
	
	
	public RecordNotFoundException(String mensagem) {
		super(mensagem);
	}

}
