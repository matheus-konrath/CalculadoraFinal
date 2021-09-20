package br.com.Compasso.calculadora.modelo;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class HistoricoEntity {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "BIGINT")
	private BigInteger id;
	@Column(name = "nome_usuario")
	private String nomeUsuario;
	@Column(name = "nome_medicamento")
	private String nomeMedicamento;
	@Column(name = "quantidade_apresentacao")
	private String quantidadeApresentacao;
	@Column(name = "quantidade_prescrita")
	private String quantidadePrescrita;
	@Column(name = "resultado_json")
	private String resultadoJson;
	@Column(name = "data_calculo")
	private Date dataCalculo;	
	@Column(name = "via_administracao")
	private String viaAdministracao;
	
	public HistoricoEntity(){
		
	}
	
	
	public HistoricoEntity(BigInteger id, String nomeUsuario, String nomeMedicamento, String quantidadeApresentacao,
			String quantidadePrescrita, String resultadoJson, Date dataCalculo) {
		this.id = id;
		this.nomeUsuario = nomeUsuario;
		this.nomeMedicamento = nomeMedicamento;
		this.quantidadeApresentacao = quantidadeApresentacao;
		this.quantidadePrescrita = quantidadePrescrita;
		this.resultadoJson = resultadoJson;
		this.dataCalculo = dataCalculo;
	}


	public BigInteger getId() {
		return id;
	}


	public void setId(BigInteger id) {
		this.id = id;
	}


	public String getNomeUsuario() {
		return nomeUsuario;
	}


	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}


	public String getNomeMedicamento() {
		return nomeMedicamento;
	}


	public void setNomeMedicamento(String nomeMedicamento) {
		this.nomeMedicamento = nomeMedicamento;
	}


	public String getQuantidadeApresentacao() {
		return quantidadeApresentacao;
	}


	public void setQuantidadeApresentacao(String quantidadeApresentacao) {
		this.quantidadeApresentacao = quantidadeApresentacao;
	}


	public String getQuantidadePrescrita() {
		return quantidadePrescrita;
	}


	public void setQuantidadePrescrita(String quantidadePrescrita) {
		this.quantidadePrescrita = quantidadePrescrita;
	}


	public String getResultadoJson() {
		return resultadoJson;
	}


	public void setResultadoJson(String resultadoJson) {
		this.resultadoJson = resultadoJson;
	}


	public Date getDataCalculo() {
		return dataCalculo;
	}


	public void setDataCalculo(Date dataCalculo) {
		this.dataCalculo = dataCalculo;
	}


	public String getViaAdministracao() {
		return viaAdministracao;
	}


	public void setViaAdministracao(String viaAdministracao) {
		this.viaAdministracao = viaAdministracao;
	}
	
	
	
	
	
	
	
}
