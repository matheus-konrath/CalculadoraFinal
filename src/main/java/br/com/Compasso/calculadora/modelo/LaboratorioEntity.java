package br.com.Compasso.calculadora.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="laboratorio")
public class LaboratorioEntity {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	
	public LaboratorioEntity(String nome) {
		this.nome = nome;
	}
	
	public LaboratorioEntity() {
		
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
	
	
	
	
}
