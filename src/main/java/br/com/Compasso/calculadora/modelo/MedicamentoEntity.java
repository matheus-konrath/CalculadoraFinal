package br.com.Compasso.calculadora.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="medicamento")
public class MedicamentoEntity {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "id")
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "laboratorio_id")
	private Long laboratorio;
	@Column(name = "grupo_medicamento_id")
	private Long grupoMedicamento;
	
	
	public MedicamentoEntity(String nome, Long laboratorio, Long grupoMedicamento) {
		this.nome = nome;
		this.laboratorio = laboratorio;
		this.grupoMedicamento = grupoMedicamento;
	}
	
	public MedicamentoEntity() {
		
	}

	public Long getId() { 
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Long laboratorio) {
		this.laboratorio = laboratorio;
	}

	public Long getGrupoMedicamento() {
		return grupoMedicamento;
	}

	public void setGrupoMedicamento(Long grupoMedicamento) {
		this.grupoMedicamento = grupoMedicamento;
	}
	
	
	
	
	
}
