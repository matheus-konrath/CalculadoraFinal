package br.com.Compasso.calculadora.dto;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import br.com.Compasso.calculadora.modelo.ViaAdministracaoEntity;

public class ViaAdministracaoDto {

	private BigInteger id;
	private String nome;
	
	
	public ViaAdministracaoDto(ViaAdministracaoEntity viaAdmin) {
		this.id = viaAdmin.getId();
		this.nome = viaAdmin.getNome();
	}


	public BigInteger getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}
	
	
	public static List<ViaAdministracaoDto> conve(List<ViaAdministracaoEntity> viaAdministracao) { // Conversão
		return viaAdministracao.stream().map(ViaAdministracaoDto::new).collect(Collectors.toList()); // retorna em forma de lista
	}
}
