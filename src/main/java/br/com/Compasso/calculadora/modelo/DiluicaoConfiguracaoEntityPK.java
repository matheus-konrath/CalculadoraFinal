package br.com.Compasso.calculadora.modelo;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class DiluicaoConfiguracaoEntityPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "medicamento_id", referencedColumnName = "id", nullable = false, insertable = true, updatable = true)
	private MedicamentoEntity medicamento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "via_administracao_id", referencedColumnName = "id", nullable = false, insertable = true, updatable = true)
	private ViaAdministracaoEntity viaAdministracao;
	
	@Column(name = "sequencia")
	private BigInteger sequencia;
	
	
	public DiluicaoConfiguracaoEntityPK(MedicamentoEntity medicamento, ViaAdministracaoEntity viaAdministracao, BigInteger sequencia) {
		this.medicamento = medicamento;
		this.viaAdministracao = viaAdministracao;
		this.sequencia = sequencia;
	}
	
	public DiluicaoConfiguracaoEntityPK() {
		
	}

	public MedicamentoEntity getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(MedicamentoEntity medicamento) {
		this.medicamento = medicamento;
	}

	public ViaAdministracaoEntity getViaAdministracao() {
		return viaAdministracao;
	}

	public void setViaAdministracao(ViaAdministracaoEntity viaAdministracao) {
		this.viaAdministracao = viaAdministracao;
	}

	public BigInteger getSequencia() {
		return sequencia;
	}

	public void setSequencia(BigInteger sequencia) {
		this.sequencia = sequencia;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DiluicaoConfiguracaoEntityPK [medicamento=" + medicamento + ", viaAdministracao=" + viaAdministracao
				+ ", sequencia=" + sequencia + "]";
	}
	
	
	
	
	
	
	
}
