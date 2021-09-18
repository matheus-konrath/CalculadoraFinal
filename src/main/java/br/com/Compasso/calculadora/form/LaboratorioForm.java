package br.com.Compasso.calculadora.form;


import java.math.BigInteger;

import br.com.Compasso.calculadora.modelo.LaboratorioEntity;
import br.com.Compasso.calculadora.repositorio.LaboratorioRepositorio;

public class LaboratorioForm {

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public LaboratorioEntity atualizar(BigInteger id , LaboratorioRepositorio laboratorioRepositorio) {
		LaboratorioEntity laboratorio = laboratorioRepositorio.getById(id);
		laboratorio.setNome(this.nome);
		return laboratorio;
	}
}