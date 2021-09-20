package br.com.Compasso.calculadora.modelo;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="laboratorio")
public class LaboratorioEntity {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;
	private String nome;
	
	
	public LaboratorioEntity(String nome) {
		this.nome = nome;
	}
	
	public LaboratorioEntity() {
		
	}
	
	public BigInteger getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	
	
	public void setId(BigInteger id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
}
