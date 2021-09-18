package br.com.Compasso.calculadora.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import com.sun.istack.NotNull;

import br.com.Compasso.calculadora.modelo.GrupoMedicamentoEntity;
import br.com.Compasso.calculadora.modelo.LaboratorioEntity;
import br.com.Compasso.calculadora.modelo.MedicamentoEntity;

public class MedicamentoDto {
	
	private BigInteger id;
	@NotNull
	private String nome;
	@NotNull
	private LaboratorioEntity laboratorio;
	@NotNull
	private GrupoMedicamentoEntity grupoMedicamento;
	private BigDecimal concentracaoInicial;
	private String embalagemApresentada;
	private BigDecimal quantidadeApresentacao;
	private String unidadeMedida;
	private String infoObservacao;
	private String infoSobra;
	private String infoTempoAdministracao;
	
	public MedicamentoDto(MedicamentoEntity medi) {
		this.id = medi.getId();
		this.nome = medi.getNome();
		this.grupoMedicamento = medi.getGrupoMedicamento();
		this.laboratorio = medi.getLaboratorio();
		this.concentracaoInicial = medi.getConcentracaoInicial();
		this.embalagemApresentada = medi.getEmbalagemApresentada();
		this.quantidadeApresentacao = medi.getQuantidadeApresentacao();
		this.unidadeMedida = medi.getUnidadeMedida();
		this.infoObservacao = medi.getInfoObservacao();
		this.infoSobra = medi.getInfoSobra();
		this.infoTempoAdministracao = medi.getInfoTempoAdministracao();
	}
	public BigInteger getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	
	
	public LaboratorioEntity getLaboratorio() {
		return laboratorio;
	}
	public GrupoMedicamentoEntity getGrupoMedicamento() {
		return grupoMedicamento;
	}
	
	
	
	public BigDecimal getConcentracaoInicial() {
		return concentracaoInicial;
	}
	public void setConcentracaoInicial(BigDecimal concentracaoInicial) {
		this.concentracaoInicial = concentracaoInicial;
	}
	public String getEmbalagemApresentada() {
		return embalagemApresentada;
	}
	public void setEmbalagemApresentada(String embalagemApresentada) {
		this.embalagemApresentada = embalagemApresentada;
	}
	public BigDecimal getQuantidadeApresentacao() {
		return quantidadeApresentacao;
	}
	public void setQuantidadeApresentacao(BigDecimal quantidadeApresentacao) {
		this.quantidadeApresentacao = quantidadeApresentacao;
	}
	public String getUnidadeMedida() {
		return unidadeMedida;
	}
	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
	public String getInfoObservacao() {
		return infoObservacao;
	}
	public void setInfoObservacao(String infoObservacao) {
		this.infoObservacao = infoObservacao;
	}
	public String getInfoSobra() {
		return infoSobra;
	}
	public void setInfoSobra(String infoSobra) {
		this.infoSobra = infoSobra;
	}
	public String getInfoTempoAdministracao() {
		return infoTempoAdministracao;
	}
	public void setInfoTempoAdministracao(String infoTempoAdministracao) {
		this.infoTempoAdministracao = infoTempoAdministracao;
	}
	
	public static List<MedicamentoDto> converter(List<MedicamentoEntity> medicamento) { // Conversão
		return medicamento.stream().map(MedicamentoDto::new).collect(Collectors.toList()); //// retorna em forma de lista
	}
}
