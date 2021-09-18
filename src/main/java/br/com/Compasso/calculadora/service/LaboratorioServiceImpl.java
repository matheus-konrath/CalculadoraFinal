package br.com.Compasso.calculadora.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.Compasso.calculadora.dto.LaboratorioDto;
import br.com.Compasso.calculadora.form.AtualizacaoLabForm;
import br.com.Compasso.calculadora.form.LaboratorioForm;
import br.com.Compasso.calculadora.modelo.LaboratorioEntity;
import br.com.Compasso.calculadora.repositorio.LaboratorioRepositorio;

@Service
public class LaboratorioServiceImpl {

	@Autowired
	private LaboratorioRepositorio laboratorioRepositorio;
	
	//Get
	public List<LaboratorioEntity> imprimi() {
		List<LaboratorioEntity> laboratorio = laboratorioRepositorio.findAll(); // Consulto todos os Dados
		return laboratorio;
	}
	
	// Get por Id
	public ResponseEntity<LaboratorioDto> detalhaId(BigInteger id){
		Optional<LaboratorioEntity> laboratorio = laboratorioRepositorio.findById(id);
		if (laboratorio.isPresent()){
			return ResponseEntity.ok(new LaboratorioDto(laboratorioRepositorio.getById(id)));
		}

		return ResponseEntity.notFound().build();
	}
	
	// Post
	public LaboratorioEntity insercao(AtualizacaoLabForm form) {
		Optional<LaboratorioEntity> lab = laboratorioRepositorio.findByNome(form.getNome());
		if(lab.isPresent()) { // verifica se esta presente
			throw new RuntimeException("Esse nome ja existe"); // gera RuntimeException
		}
		else if(form.getNome().length() == 0) { // examina se o campo nome estiver vazio
			throw new RuntimeException("Vazio");
		}
		
		LaboratorioEntity laboratorio = form.converte();
		return laboratorioRepositorio.save(laboratorio); // Salvar no Banco de Dados

	}
	
	//Put
	public LaboratorioEntity atualizar(BigInteger id, LaboratorioForm form) {
		Optional<LaboratorioEntity> optional = laboratorioRepositorio.findById(id);
		if(optional.isPresent()) {
			if(form.getNome().length() == 0) {
			throw new RuntimeException("Vazio");
			}
			return form.atualizar(id, laboratorioRepositorio); //Atualiza o nome
		}
		throw new RuntimeException("Esse id não existe");
		
	}
	
	public ResponseEntity<?> excluir(BigInteger id) {
		Optional<LaboratorioEntity> laboratorio = laboratorioRepositorio.findById(id);
		if (laboratorio.isPresent()) {
			laboratorioRepositorio.deleteById(id);  // remove pelo id
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build(); // não encontrado
	}
}
