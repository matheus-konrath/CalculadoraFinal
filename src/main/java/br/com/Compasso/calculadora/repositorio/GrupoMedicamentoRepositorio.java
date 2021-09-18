package br.com.Compasso.calculadora.repositorio;


import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import br.com.Compasso.calculadora.modelo.GrupoMedicamentoEntity;



@Repository
public interface GrupoMedicamentoRepositorio extends JpaRepository<GrupoMedicamentoEntity, BigInteger>{
	
	Optional<GrupoMedicamentoEntity> findByNome(String nome);

}
