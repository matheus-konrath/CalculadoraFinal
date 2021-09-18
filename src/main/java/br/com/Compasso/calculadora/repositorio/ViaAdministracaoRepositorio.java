package br.com.Compasso.calculadora.repositorio;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.Compasso.calculadora.modelo.ViaAdministracaoEntity;

public interface ViaAdministracaoRepositorio extends JpaRepository<ViaAdministracaoEntity, BigInteger> {
	Optional<ViaAdministracaoEntity> findByNome(String nome);
	
	
}
