package br.com.Compasso.calculadora.repositorio;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.Compasso.calculadora.modelo.HistoricoEntity;

@Repository
public interface HistoricoRespositorio extends JpaRepository<HistoricoEntity, BigInteger> {
	@Query(value = "select * from historico " + "where nome_medicamento = :nomeMedicamento "
			+ "and data_calculo between :dataInicio and :dataFim", nativeQuery = true)

	List<HistoricoEntity> findByNomeAndBetweenDatas(String nome, LocalDate dataInicio, LocalDate dataFim);
}
