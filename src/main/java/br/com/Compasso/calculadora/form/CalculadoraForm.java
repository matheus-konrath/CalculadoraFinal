package br.com.Compasso.calculadora.form;

import java.math.BigDecimal;
import java.math.BigInteger;

public class CalculadoraForm {

	private String nomeUsuario;
	private BigDecimal prescricao;
	private BigInteger idMedicamento;
	private BigInteger idViaAdministracao;
	
	
	
	public CalculadoraForm(String nomeUsuario, BigDecimal prescricao, BigInteger idMedicamento,
			BigInteger idViaAdministracao) {
		this.nomeUsuario = nomeUsuario;
		this.prescricao = prescricao;
		this.idMedicamento = idMedicamento;
		this.idViaAdministracao = idViaAdministracao;
	}



	public String getNomeUsuario() {
		return nomeUsuario;
	}



	public BigDecimal getPrescricao() {
		return prescricao;
	}



	public BigInteger getIdMedicamento() {
		return idMedicamento;
	}



	public BigInteger getIdViaAdministracao() {
		return idViaAdministracao;
	}
	
	
	
	
	
	
}
