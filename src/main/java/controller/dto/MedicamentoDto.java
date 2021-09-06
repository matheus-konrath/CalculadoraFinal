package br.com.Compasso.calculadora.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.Compasso.calculadora.modelo.GrupoMedicamentos;



public class MedicamentoDto {
	
	private Long id;
	private String nome;
	
	public MedicamentoDto(GrupoMedicamentos medi) {
		this.id = medi.getId();
		this.nome = medi.getNome();
	}
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public static List<MedicamentoDto> converter(List<GrupoMedicamentos> medicamento) {
		return medicamento.stream().map(MedicamentoDto::new).collect(Collectors.toList());
	}
	
	
	

}
