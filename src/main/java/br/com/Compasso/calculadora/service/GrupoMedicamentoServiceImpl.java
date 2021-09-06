package br.com.Compasso.calculadora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.Compasso.calculadora.dto.GrupoMedicamentoDto;
import br.com.Compasso.calculadora.form.AtualizacaoGrupoForm;
import br.com.Compasso.calculadora.form.GrupoMedicamentoForm;
import br.com.Compasso.calculadora.modelo.GrupoMedicamentoEntity;
import br.com.Compasso.calculadora.repositorio.GrupoMedicamentoRepositorio;

@Service
public class GrupoMedicamentoServiceImpl {

	@Autowired
	private GrupoMedicamentoRepositorio grupoMedicamentoRepositorio;

	//busca elementos do grupoMedicamentos inseridos  #GET
	public List<GrupoMedicamentoEntity> imprimi() {
		List<GrupoMedicamentoEntity> grupo = grupoMedicamentoRepositorio.findAll(); // Consulta todos os registros
		return grupo;
	}
	// GET por id, busca pelo id
	public ResponseEntity<GrupoMedicamentoDto> detalhaId(Long id) {
		Optional<GrupoMedicamentoEntity> medicamento = grupoMedicamentoRepositorio.findById(id);
		if (medicamento.isPresent()) { // Verifica se tem 
			return ResponseEntity.ok(new GrupoMedicamentoDto(grupoMedicamentoRepositorio.getById(id))); 
		}

		return ResponseEntity.notFound().build(); // Não encontrado
	}
	
	// POST insere no Banco de dados
	public GrupoMedicamentoEntity insercao(AtualizacaoGrupoForm form) {
		Optional<GrupoMedicamentoEntity> grupo = grupoMedicamentoRepositorio.findByNome(form.getNome());
		if(grupo.isPresent()) {	// verifica se esta presente
			throw new RuntimeException("Esse nome ja existe");	// gera RuntimeException
		}
		else if(form.getNome().length() == 0) {	// examina se o campo nome estiver vazio
			throw new RuntimeException("Vazio");
		}
		
		GrupoMedicamentoEntity grupoMedicamento = form.converter();
		return grupoMedicamentoRepositorio.save(grupoMedicamento); // Salvar no Banco de Dados

	}
	//PUT atualiza o elemento
	public GrupoMedicamentoEntity atualizar(Long id, GrupoMedicamentoForm form) {
		Optional<GrupoMedicamentoEntity> optional = grupoMedicamentoRepositorio.findById(id);
		if(optional.isPresent()) {
			if(form.getNome().length() == 0) {
			throw new RuntimeException("Vazio");
			}
			return form.atualiza(id, grupoMedicamentoRepositorio); //Atualiza o nome
		}
		throw new RuntimeException("Esse id não existe");
		
	}
	
	// DELETE remove o elemento do Banco de dados
	public ResponseEntity<?> remover(Long id) {
		Optional<GrupoMedicamentoEntity> grupo = grupoMedicamentoRepositorio.findById(id);
		if (grupo.isPresent()) {
			grupoMedicamentoRepositorio.deleteById(id); // remove pelo id
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
