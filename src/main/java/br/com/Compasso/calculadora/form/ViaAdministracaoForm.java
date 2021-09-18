package br.com.Compasso.calculadora.form;

import br.com.Compasso.calculadora.modelo.ViaAdministracaoEntity;

public class ViaAdministracaoForm {

	private Long id;
	private String nome;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public ViaAdministracaoEntity converte() {
		return new ViaAdministracaoEntity(nome);
	}
}
