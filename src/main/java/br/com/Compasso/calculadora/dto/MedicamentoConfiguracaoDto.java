package br.com.Compasso.calculadora.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import br.com.Compasso.calculadora.modelo.GrupoMedicamentoEntity;
import br.com.Compasso.calculadora.modelo.LaboratorioEntity;
import br.com.Compasso.calculadora.modelo.MedicamentoEntity;

public class MedicamentoConfiguracaoDto {

	private BigInteger id;
	private String nome;
	private GrupoMedicamentoEntity idMedicamento;
	private LaboratorioEntity idLaboratorio;
	private BigDecimal quantidadeApresentacao;
	private BigDecimal concentracaoInicial;
	private String infoSobra;
	private String infoObservacao;
	private String infoTempoAdministracao;
	private String unidadeMedida;
	private String embalagemApresentada;
	private List<DiluicaoDto> diluicaoConfiguracaoList;

	public MedicamentoConfiguracaoDto(MedicamentoEntity medicamento, List<DiluicaoDto> diluicaoConfiguracaoDtos) {
		this.id = medicamento.getId();
		this.nome = medicamento.getNome();
		this.idMedicamento = medicamento.getGrupoMedicamento();//.getId();
		this.idLaboratorio = medicamento.getLaboratorio();//.getId();
		this.quantidadeApresentacao = medicamento.getQuantidadeApresentacao();
		this.concentracaoInicial = medicamento.getConcentracaoInicial();
		this.infoSobra = medicamento.getInfoSobra();
		this.infoObservacao = medicamento.getInfoObservacao();
		this.infoTempoAdministracao = medicamento.getInfoTempoAdministracao();
		this.unidadeMedida = medicamento.getUnidadeMedida();
		this.embalagemApresentada = medicamento.getEmbalagemApresentada();
		this.diluicaoConfiguracaoList = new ArrayList<DiluicaoDto>();
		diluicaoConfiguracaoDtos.forEach(diluicao -> {
			this.diluicaoConfiguracaoList.add(diluicao);
		});
	}
	
	public MedicamentoConfiguracaoDto(MedicamentoEntity medicamento) {
		this.id = medicamento.getId();
		this.nome = medicamento.getNome();
		this.idMedicamento = medicamento.getGrupoMedicamento();//.getId();
		this.idLaboratorio = medicamento.getLaboratorio();//.getId();
		this.quantidadeApresentacao = medicamento.getQuantidadeApresentacao();
		this.concentracaoInicial = medicamento.getConcentracaoInicial();
		this.infoSobra = medicamento.getInfoSobra();
		this.infoObservacao = medicamento.getInfoObservacao();
		this.infoTempoAdministracao = medicamento.getInfoTempoAdministracao();
		this.unidadeMedida = medicamento.getUnidadeMedida();
		this.embalagemApresentada = medicamento.getEmbalagemApresentada();
	}

	public BigInteger getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public GrupoMedicamentoEntity getIdMedicamento() {
		return idMedicamento;
	}

	public LaboratorioEntity getIdLaboratorio() {
		return idLaboratorio;
	}

	public BigDecimal getQuantidadeApresentacao() {
		return quantidadeApresentacao;
	}

	public BigDecimal getConcentracaoInicial() {
		return concentracaoInicial;
	}

	public String getInfoSobra() {
		return infoSobra;
	}

	public String getInfoObservacao() {
		return infoObservacao;
	}

	public String getInfoTempoAdministracao() {
		return infoTempoAdministracao;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public String getEmbalagemApresentada() {
		return embalagemApresentada;
	}

	public List<DiluicaoDto> getDiluicaoConfiguracaoList() {
		return diluicaoConfiguracaoList;
	}

	
	
	
}
