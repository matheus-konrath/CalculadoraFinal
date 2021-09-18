package br.com.Compasso.calculadora.dto;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import br.com.Compasso.calculadora.modelo.LaboratorioEntity;

public class LaboratorioDto {

	private BigInteger id;
	private String nome;
	
	public LaboratorioDto(LaboratorioEntity lab) {
		this.id = lab.getId();
		this.nome = lab.getNome();
	}
	public BigInteger getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public static List<LaboratorioDto> converter(List<LaboratorioEntity> laboratorio) {
		return laboratorio.stream().map(LaboratorioDto::new).collect(Collectors.toList());
	}
	
}
