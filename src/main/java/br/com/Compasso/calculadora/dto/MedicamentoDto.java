package br.com.Compasso.calculadora.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.sun.istack.NotNull;

import br.com.Compasso.calculadora.modelo.MedicamentoEntity;

public class MedicamentoDto {
	
	private Long id;
	@NotNull
	private String nome;
	@NotNull
	private Long laboratorio;
	@NotNull
	private Long grupoMedicamento;
	
	public MedicamentoDto(MedicamentoEntity medi) {
		this.id = medi.getId();
		this.nome = medi.getNome();
		this.grupoMedicamento = medi.getGrupoMedicamento();
		this.laboratorio = medi.getLaboratorio();
	}
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	
	
	public Long getLaboratorio() {
		return laboratorio;
	}
	public Long getGrupoMedicamento() {
		return grupoMedicamento;
	}
	
	
	public static List<MedicamentoDto> converter(List<MedicamentoEntity> medicamento) { // Conversão
		return medicamento.stream().map(MedicamentoDto::new).collect(Collectors.toList()); //// retorna em forma de lista
	}
}
