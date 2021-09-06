package br.com.Compasso.calculadora.controller;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.Compasso.calculadora.dto.LaboratorioDto;
import br.com.Compasso.calculadora.form.AtualizacaoLabForm;
import br.com.Compasso.calculadora.form.LaboratorioForm;
import br.com.Compasso.calculadora.modelo.LaboratorioEntity;
import br.com.Compasso.calculadora.service.LaboratorioServiceImpl;
import io.swagger.annotations.Api;

@RestController
@ResponseBody
@Api(value = "laboratorio")
@RequestMapping("/laboratorio")
public class LaboratorioController {

	
	
	@Autowired
	private LaboratorioServiceImpl laboratorioService;
	
	// Gera todos os elementos do GrupoMedicamentos
	@GetMapping("/laboratorio")
	public List<LaboratorioDto> getLaboratorio() {
		return LaboratorioDto.converter(laboratorioService.imprimi());
	}

	// Insere um elemento
	@PostMapping("/laboratorio")
	@Transactional
	public LaboratorioDto Cadastrar(@RequestBody @Validated AtualizacaoLabForm form) {
		LaboratorioEntity laboratorio = laboratorioService.insercao(form);
		return new LaboratorioDto(laboratorio);
	}

	// Busca o elemento pelo id
	@GetMapping("/laboratorio/{id}")
	public ResponseEntity<LaboratorioDto> detalhar(@PathVariable Long id) {
		ResponseEntity<LaboratorioDto> lab = laboratorioService.detalhaId(id);
		return lab;
	}

	// Atualiza o elemento
	@PutMapping("/laboratorio/{id}")
	@Transactional
	public ResponseEntity<LaboratorioDto> atua(@PathVariable Long id,  @RequestBody @Validated LaboratorioForm form) {
		LaboratorioEntity laboratorio = laboratorioService.atualizar(id, form);
		return ResponseEntity.ok(new LaboratorioDto(laboratorio));
	}
	
	
	// Remove do Banco de Dados
	@DeleteMapping("{id}")
	public ResponseEntity<?> exc(@PathVariable Long id) {
		 ResponseEntity<?> laboratorio = laboratorioService.excluir(id);
		 return laboratorio;
		
	}
	
}
