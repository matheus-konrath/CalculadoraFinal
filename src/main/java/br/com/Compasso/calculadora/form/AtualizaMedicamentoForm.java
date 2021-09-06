package br.com.Compasso.calculadora.form;


import br.com.Compasso.calculadora.modelo.MedicamentoEntity;
import br.com.Compasso.calculadora.repositorio.MedicamentoRepositorio;

public class AtualizaMedicamentoForm {

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public MedicamentoEntity alterar(Long id , MedicamentoRepositorio medicamentoRespositorio) {
		MedicamentoEntity medicamento = medicamentoRespositorio.getById(id);
		medicamento.setNome(this.nome);
		return medicamento;
	}
}
