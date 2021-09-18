package br.com.Compasso.calculadora.modelo;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "viaAdministracao")
public class ViaAdministracaoEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;
	@Column(name = "nome")
	private String nome;
	
	
	public ViaAdministracaoEntity( String nome) {	
		this.nome = nome;
	}
	
	public ViaAdministracaoEntity() {
		
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
