package br.com.Compasso.calculadora.repositorio;


import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.Compasso.calculadora.modelo.LaboratorioEntity;

public interface LaboratorioRepositorio extends JpaRepository<LaboratorioEntity, BigInteger> {
	
		Optional<LaboratorioEntity> findByNome(String nome);

		

}
