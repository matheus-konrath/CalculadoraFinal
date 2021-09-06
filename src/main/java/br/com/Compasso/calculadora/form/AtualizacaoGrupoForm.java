package br.com.Compasso.calculadora.form;

import com.sun.istack.NotNull;

import br.com.Compasso.calculadora.modelo.GrupoMedicamentoEntity;


public class AtualizacaoGrupoForm {

	@NotNull
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public GrupoMedicamentoEntity converter() {
		return new GrupoMedicamentoEntity(nome);
	}
}
