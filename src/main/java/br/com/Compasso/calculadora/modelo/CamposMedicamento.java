package br.com.Compasso.calculadora.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CamposMedicamento implements Serializable{

	@Column(name = "concentracao_inicial")
	private double concentracaoInicial;
	
	@Column(name = "embalagem_apresentada")
	private String embalagemApresentada;
	
	@Column(name = "quantidade_apresentada")
	private double quantidadeApresentacao;
	
	@Column(name = "unidade_medida")
	private String unidadeMedida;
	
	@Column(name = "info_observacao")
	private String infoObservacao;
	
	@Column(name = "info_sobra")
	private String infoSobra;
	
	@Column(name = "info_tempo_administracao")
	private String infoTempoAdministracao;
	
	
	public CamposMedicamento(double concentracaoInicial, String embalagemApresentada,
			double quantidadeApresentacao, String unidadeMedida, String infoObservacao,
			String infoSobra, String infoTempoAdministracao) {
		
		this.concentracaoInicial = concentracaoInicial ;
		this.embalagemApresentada = embalagemApresentada;
		this.quantidadeApresentacao = quantidadeApresentacao;
		this.unidadeMedida = unidadeMedida;
		this.infoObservacao = infoObservacao;
		this.infoSobra = infoSobra;
		this.infoTempoAdministracao = infoTempoAdministracao;
		
	}


	public double getConcentracaoInicial() {
		return concentracaoInicial;
	}


	public String getEmbalagemApresentada() {
		return embalagemApresentada;
	}


	public double getQuantidadeApresentacao() {
		return quantidadeApresentacao;
	}


	public String getUnidadeMedida() {
		return unidadeMedida;
	}


	public String getInfoObservacao() {
		return infoObservacao;
	}


	public String getInfoSobra() {
		return infoSobra;
	}


	public String getInfoTempoAdministracao() {
		return infoTempoAdministracao;
	}
	
	
	
}
