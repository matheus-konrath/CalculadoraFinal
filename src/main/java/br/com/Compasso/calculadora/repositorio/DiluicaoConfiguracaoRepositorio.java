package br.com.Compasso.calculadora.repositorio;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.Compasso.calculadora.modelo.DiluicaoConfiguracaoEntity;
import br.com.Compasso.calculadora.modelo.DiluicaoConfiguracaoEntityPK;

@Repository
public interface DiluicaoConfiguracaoRepositorio extends JpaRepository<DiluicaoConfiguracaoEntity, DiluicaoConfiguracaoEntityPK> {
	@Query(value = "select * from diluicao_configuracao dc "
			+ "where dc.medicamento_id = :idMedicamento "
			+ "and dc.via_administracao_id = :idViaAdministracao",
			nativeQuery = true)
	List<DiluicaoConfiguracaoEntity> findDiluicaoConfiguracaoViaMed(BigInteger idMedicamento, BigInteger idViaAdministracao );
	

}
