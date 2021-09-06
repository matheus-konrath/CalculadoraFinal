package br.com.Compasso.calculadora.repositorio;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.Compasso.calculadora.modelo.MedicamentoEntity;

public interface MedicamentoRepositorio extends JpaRepository<MedicamentoEntity, Long> {
	Optional<MedicamentoEntity> findByNome(String nome);


}
