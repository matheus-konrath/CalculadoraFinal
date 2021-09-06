package br.com.Compasso.calculadora.form;
import br.com.Compasso.calculadora.modelo.LaboratorioEntity;

public class AtualizacaoLabForm {

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public LaboratorioEntity converte() {
		return new LaboratorioEntity(nome);
	}
}

