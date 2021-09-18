package br.com.Compasso.calculadora.form;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class MedicamentoConfiguraForm {

	private String nome;
	private BigInteger idGrupoMedicamento;
	private BigInteger idLaboratorio;
	private BigDecimal quantidadeApresentada;
	private BigDecimal concentracaoInicial;
	private String infoSobra;
	private String infoObservacao;
	private String infoTempoAdministracao;
	private String unidadeMedida;
	private String embalagemApresentada;
	List<DiluicaoForm> diluicaoList;
	
	
	
	public MedicamentoConfiguraForm(String nome, BigInteger idGrupoMedicamento, BigInteger idLaboratorio,
			BigDecimal quantidadeApresentada, BigDecimal concentracaoInicial, String infoSobra, String infoObservacao,
			String infoTempoAdministracao, String unidadeMedida, String embalagemApresentada,
			List<DiluicaoForm> diluicaoConfiguracaoForm) {
		this.nome = nome;
		this.idGrupoMedicamento = idGrupoMedicamento;
		this.idLaboratorio = idLaboratorio;
		this.quantidadeApresentada = quantidadeApresentada;
		this.concentracaoInicial = concentracaoInicial;
		this.infoSobra = infoSobra;
		this.infoObservacao = infoObservacao;
		this.infoTempoAdministracao = infoTempoAdministracao;
		this.unidadeMedida = unidadeMedida;
		this.embalagemApresentada = embalagemApresentada;
		diluicaoConfiguracaoForm.forEach(diluicao -> {
			this.diluicaoList.add(diluicao);
		}); 
		
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
		return quantidadeApresentada;
	}



	public void setQuantidadeApresentacao(BigDecimal quantidadeApresentada) {
		this.quantidadeApresentada = quantidadeApresentada;
	}



	public BigDecimal getConcentracaoInicial() {
		return concentracaoInicial;
	}



	public void setConcentracaoInicial(BigDecimal concentracaoInicial) {
		this.concentracaoInicial = concentracaoInicial;
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



	public List<DiluicaoForm> getDiluicaoConfiguracao() {
		return diluicaoList;
	}



	public void setDiluicaoConfiguracao(List<DiluicaoForm> diluicaoConfiguracaoList) {
		this.diluicaoList = diluicaoConfiguracaoList;
	}
	
	
	
	
	
}
