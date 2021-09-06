package br.com.Compasso.calculadora.form;
import br.com.Compasso.calculadora.modelo.MedicamentoEntity;

public class MedicamentoForm {

	private String nome;
	private Long laboratorio;
	private Long grupoMedicamento;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	public Long getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Long laboratorio) {
		this.laboratorio = laboratorio;
	}

	public Long getGrupoMedicamento() {
		return grupoMedicamento;
	}

	public void setGrupoMedicamento(Long grupoMedicamento) {
		this.grupoMedicamento = grupoMedicamento;
	}

	public MedicamentoEntity converter() {
		return new MedicamentoEntity(nome, laboratorio, grupoMedicamento);
	}
}
