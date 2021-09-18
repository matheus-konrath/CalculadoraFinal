package br.com.Compasso.calculadora.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.Compasso.calculadora.modelo.DiluicaoConfiguracaoEntity;
import br.com.Compasso.calculadora.modelo.DiluicaoConfiguracaoEntityPK;


public interface DiluicaoConfiguracaoRepositorio extends JpaRepository<DiluicaoConfiguracaoEntity, DiluicaoConfiguracaoEntityPK> {
	

}
