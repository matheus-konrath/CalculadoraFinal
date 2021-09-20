package br.com.Compasso.calculadora.form;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

public class MedicamentoConfiguraForm {

	private String nome;
	private BigInteger idGrupoMedicamento;
	private BigInteger idLaboratorio;
	private BigDecimal quantidadeApresentacao;
	private BigDecimal concentracao;
	private String infoSobra;
	private String infoObservacao;
	private String infoTempoAdministracao;
	private String unidadeMedida;
	private String embalagemApresentada;
	List<DiluicaoConfiguracaoAtualizarForm> diluicaoConfiguracaoList;
	
	
	
	public MedicamentoConfiguraForm(String nome, BigInteger idGrupoMedicamento, BigInteger idLaboratorio,
			BigDecimal quantidadeApresentacao, BigDecimal concentracaoInicial, String infoSobra, String infoObservacao,
			String infoTempoAdministracao, String unidadeMedida, String embalagemApresentada,
			List<DiluicaoConfiguracaoAtualizarForm> diluicaoConfiguracaoForm) {
		this.nome = nome;
		this.idGrupoMedicamento = idGrupoMedicamento;
		this.idLaboratorio = idLaboratorio;
		this.quantidadeApresentacao = quantidadeApresentacao;
		this.concentracao = concentracaoInicial;
		this.infoSobra = infoSobra;
		this.infoObservacao = infoObservacao;
		this.infoTempoAdministracao = infoTempoAdministracao;
		this.unidadeMedida = unidadeMedida;
		this.embalagemApresentada = embalagemApresentada;
		diluicaoConfiguracaoForm.forEach(diluicao -> {
			this.diluicaoConfiguracaoList.add(diluicao);
		});
		
	}
	public MedicamentoConfiguraForm() {
		
	}


	public List<DiluicaoConfiguracaoAtualizarForm> getDiluicaoConfiguracaoList() {
		return Collections.unmodifiableList(diluicaoConfiguracaoList);
	}

	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public BigInteger getIdGrupoMedicamento() {
		return idGrupoMedicamento;
	}



	public void setIdGrupoMedicamento(BigInteger idGrupoMedicamento) {
		this.idGrupoMedicamento = idGrupoMedicamento;
	}



	public BigInteger getIdLaboratorio() {
		return idLaboratorio;
	}



	public void setIdLaboratorio(BigInteger idLaboratorio) {
		this.idLaboratorio = idLaboratorio;
	}



	public BigDecimal getQuantidadeApresentacao() {
		return quantidadeApresentacao;
	}



	public void setQuantidadeApresentacao(BigDecimal quantidadeApresentacao) {
		this.quantidadeApresentacao = quantidadeApresentacao;
	}



	public BigDecimal getConcentracaoInicial() {
		return concentracao;
	}



	public void setConcentracaoInicial(BigDecimal concentracaoInicial) {
		this.concentracao = concentracaoInicial;
	}



	public String getInfoSobra() {
		return infoSobra;
	}



	public void setInfoSobra(String infoSobra) {
		this.infoSobra = infoSobra;
	}



	public String getInfoObservacao() {
		return infoObservacao;
	}



	public void setInfoObservacao(String infoObservacao) {
		this.infoObservacao = infoObservacao;
	}



	public String getInfoTempoAdministracao() {
		return infoTempoAdministracao;
	}



	public void setInfoTempoAdministracao(String infoTempoAdministracao) {
		this.infoTempoAdministracao = infoTempoAdministracao;
	}



	public String getUnidadeMedida() {
		return unidadeMedida;
	}



	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}



	public String getEmbalagemApresentada() {
		return embalagemApresentada;
	}



	public void setEmbalagemApresentada(String embalagemApresentada) {
		this.embalagemApresentada = embalagemApresentada;
	}



	
	
	
	
}
