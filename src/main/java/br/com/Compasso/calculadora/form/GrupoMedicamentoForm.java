package br.com.Compasso.calculadora.form;

import com.sun.istack.NotNull;

import br.com.Compasso.calculadora.modelo.GrupoMedicamentoEntity;
import br.com.Compasso.calculadora.repositorio.GrupoMedicamentoRepositorio;

public class GrupoMedicamentoForm {

	@NotNull
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public GrupoMedicamentoEntity atualiza(Long id , GrupoMedicamentoRepositorio grupoMedicamentoRespositorio) {
		GrupoMedicamentoEntity grupo = grupoMedicamentoRespositorio.getById(id);
		grupo.setNome(this.nome);
		return grupo;
	}
}
