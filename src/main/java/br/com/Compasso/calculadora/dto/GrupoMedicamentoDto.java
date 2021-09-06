package br.com.Compasso.calculadora.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.Compasso.calculadora.modelo.GrupoMedicamentoEntity;



public class GrupoMedicamentoDto {
	
	//Atrinutos
	private Long id;
	private String nome;
	
	// Método Construtor
	public GrupoMedicamentoDto(GrupoMedicamentoEntity medi) {
		this.id = medi.getId();
		this.nome = medi.getNome();
	}
	//Getters
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	
	public static List<GrupoMedicamentoDto> converter(List<GrupoMedicamentoEntity> medicamento) { // Conversão
		return medicamento.stream().map(GrupoMedicamentoDto::new).collect(Collectors.toList()); // retorna em forma de lista
	}
	
	
	

}
