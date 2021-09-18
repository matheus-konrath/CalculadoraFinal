package br.com.Compasso.calculadora.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import br.com.Compasso.calculadora.modelo.DiluicaoConfiguracaoEntity;


public class DiluicaoDto {

	private BigInteger sequencia;
	private BigInteger medicamentoId;
	private BigInteger viaAdministracao;
	private BigDecimal quantidadeAspirada;
	private BigDecimal quantidadeAdicionada;
	private BigDecimal concentracao;
	private String modoPreparo;
	private String diluente;
	
	
	public DiluicaoDto(DiluicaoConfiguracaoEntity diluicao) {
		this.sequencia = diluicao.getSequencia();
		this.medicamentoId = diluicao.getMedicamentoId();
		this.viaAdministracao = diluicao.getViaAdministracaoId();
		this.quantidadeAspirada = diluicao.getQuantidadeAspirada();
		this.quantidadeAdicionada = diluicao.getQuantidadeAdicionada();
		this.concentracao = diluicao.getConcentracao();
		this.modoPreparo = diluicao.getModoPreparo();
		this.diluente = diluicao.getDiluente();
	}


	public BigInteger getSequencia() {
		return sequencia;
	}


	public BigInteger getMedicamentoId() {
		return medicamentoId;
	}


	public BigInteger getViaAdministracao() {
		return viaAdministracao;
	}


	public BigDecimal getQuantidadeAspirada() {
		return quantidadeAspirada;
	}


	public BigDecimal getQuantidadeAdicionada() {
		return quantidadeAdicionada;
	}


	public BigDecimal getConcentracao() {
		return concentracao;
	}


	public String getModoPreparo() {
		return modoPreparo;
	}


	public String getDiluente() {
		return diluente;
	}
	

	public static List<DiluicaoDto> converter(List<DiluicaoConfiguracaoEntity> diluicao) { // Conversão
		return diluicao.stream().map(DiluicaoDto::new).collect(Collectors.toList()); //// retorna em forma de lista
	}
	
	
}
