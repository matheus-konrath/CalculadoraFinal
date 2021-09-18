package br.com.Compasso.calculadora.form;

import java.math.BigInteger;

import br.com.Compasso.calculadora.modelo.ViaAdministracaoEntity;
import br.com.Compasso.calculadora.repositorio.ViaAdministracaoRepositorio;

public class AtualizaViaAdmForm {

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public ViaAdministracaoEntity altera(BigInteger id , ViaAdministracaoRepositorio viaRespositorio) {
		ViaAdministracaoEntity viaAdm = viaRespositorio.getById(id);
		viaAdm.setNome(this.nome);
		return viaAdm;
	}
	
}
