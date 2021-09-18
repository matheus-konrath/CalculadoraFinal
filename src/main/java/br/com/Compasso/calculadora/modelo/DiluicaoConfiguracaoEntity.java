package br.com.Compasso.calculadora.modelo;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "diluicao_configuracao")
public class DiluicaoConfiguracaoEntity {
	
	@EmbeddedId
	private DiluicaoConfiguracaoEntityPK diluicaoConfiguracaoPK;
	
	@Column(name = "medicamento_id", nullable = false, insertable = false, updatable = false)
	private BigInteger medicamentoId;
	
	@Column(name = "via_administracao_id", nullable = false, insertable = false, updatable = false)
	private BigInteger viaAdministracaoId;
	
	@Column(name = "sequencia", nullable = false, insertable = false, updatable = false)
	private BigInteger sequencia;
	
	@Column(name = "quantidade_aspirada")
	private BigDecimal quantidadeAspirada;
	
	@Column(name = "quantidade_adicionada", nullable = false)
	private BigDecimal quantidadeAdicionada;
	
	@Column(name = "concentracao")
	private BigDecimal concentracao;
	
	@Column(name = "diluente")
	private String diluente;
	
	@Column(name = "modo_preparo")
	private String modoPreparo;
	
	
	public DiluicaoConfiguracaoEntity(MedicamentoEntity medicamento, ViaAdministracaoEntity viaAdministracao, BigInteger sequencia,
			BigDecimal quantidadeAspirada, BigDecimal quantidadeAdicionada, BigDecimal concentracao,
			String diluente, String modoPreparo) {
		this.diluicaoConfiguracaoPK = new DiluicaoConfiguracaoEntityPK(medicamento, viaAdministracao, sequencia);
		this.quantidadeAdicionada = quantidadeAdicionada;
		this.quantidadeAspirada = quantidadeAspirada;
		this.concentracao = concentracao;
		this.diluente = diluente;
		this.modoPreparo = modoPreparo;
		
	}
	
	public DiluicaoConfiguracaoEntity() {
		
	}

	public DiluicaoConfiguracaoEntityPK getDiluicaoConfiguracaoPK() {
		return diluicaoConfiguracaoPK;
	}

	public void setDiluicaoConfiguracaoPK(MedicamentoEntity medicamento, ViaAdministracaoEntity viaAdministracao, BigInteger sequencia) {
		this.diluicaoConfiguracaoPK = new DiluicaoConfiguracaoEntityPK(medicamento, viaAdministracao, sequencia);
	}

	public BigInteger getMedicamentoId() {
		return medicamentoId;
	}

	public void setMedicamentoId(BigInteger medicamentoId) {
		this.medicamentoId = medicamentoId;
	}

	public BigInteger getViaAdministracaoId() {
		return viaAdministracaoId;
	}

	public void setViaAdministracaoId(BigInteger viaAdministracaoId) {
		this.viaAdministracaoId = viaAdministracaoId;
	}

	public BigInteger getSequencia() {
		return sequencia;
	}

	public void setSequencia(BigInteger sequencia) {
		this.sequencia = sequencia;
	}

	public BigDecimal getQuantidadeAspirada() {
		return quantidadeAspirada;
	}

	public void setQuantidadeAspirada(BigDecimal quantidadeAspirada) {
		this.quantidadeAspirada = quantidadeAspirada;
	}

	public BigDecimal getQuantidadeAdicionada() {
		return quantidadeAdicionada;
	}

	public void setQuantidadeAdicionada(BigDecimal quantidadeAdicionada) {
		this.quantidadeAdicionada = quantidadeAdicionada;
	}

	public BigDecimal getConcentracao() {
		return concentracao;
	}

	public void setConcentracao(BigDecimal concentracao) {
		this.concentracao = concentracao;
	}

	public String getDiluente() {
		return diluente;
	}

	public void setDiluente(String diluente) {
		this.diluente = diluente;
	}

	public String getModoPreparo() {
		return modoPreparo;
	}

	public void setModoPreparo(String modoPreparo) {
		this.modoPreparo = modoPreparo;
	}


}
