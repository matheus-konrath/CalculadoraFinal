package br.com.Compasso.calculadora.dto;

import java.math.BigInteger;
import java.util.Date;

import br.com.Compasso.calculadora.modelo.HistoricoEntity;

public class HistoricoDto {

	private BigInteger id;
	private String nomeUsuario;
	private String nomeMedicamento;
	private String quantidadeApresentacao;
	private String quantidadePrescrita;
	private String resultadoJson;
	private Date dataCalculo;
	
	
	
	
	public HistoricoDto(BigInteger id, String nomeUsuario, String nomeMedicamento, String quantidadeApresentacao,
			String quantidadePrescrita, String resultadoJson, Date dataCalculo) {
		
		this.id = id;
		this.nomeUsuario = nomeUsuario;
		this.nomeMedicamento = nomeMedicamento;
		this.quantidadeApresentacao = quantidadeApresentacao;
		this.quantidadePrescrita = quantidadePrescrita;
		this.resultadoJson = resultadoJson;
		this.dataCalculo = dataCalculo;
	}


	public HistoricoDto(HistoricoEntity historico) {
	
		this.id = historico.getId();
		this.nomeUsuario = historico.getNomeUsuario();
		this.nomeMedicamento = historico.getNomeMedicamento();
		this.quantidadeApresentacao = historico.getQuantidadeApresentacao();
		this.quantidadePrescrita = historico.getQuantidadePrescrita();
		this.resultadoJson = historico.getResultadoJson();
		this.dataCalculo = historico.getDataCalculo();
	}
	
	public HistoricoDto() {
		
	}


	public BigInteger getId() {
		return id;
	}


	public String getNomeUsuario() {
		return nomeUsuario;
	}


	public String getNomeMedicamento() {
		return nomeMedicamento;
	}


	public String getQuantidadeApresentacao() {
		return quantidadeApresentacao;
	}


	public String getQuantidadePrescrita() {
		return quantidadePrescrita;
	}


	public String getResultadoJson() {
		return resultadoJson;
	}


	public Date getDataCalculo() {
		return dataCalculo;
	}
	
	
	
	
	
	
}
