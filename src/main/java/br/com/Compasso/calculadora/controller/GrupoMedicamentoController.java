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


import br.com.Compasso.calculadora.dto.GrupoMedicamentoDto;
import br.com.Compasso.calculadora.form.AtualizacaoGrupoForm;
import br.com.Compasso.calculadora.form.GrupoMedicamentoForm;
import br.com.Compasso.calculadora.modelo.GrupoMedicamentoEntity;
import br.com.Compasso.calculadora.service.GrupoMedicamentoServiceImpl;
import io.swagger.annotations.Api;

@RestController
@ResponseBody
@Api(value = "grupomedicamento")
@RequestMapping("/grupomedicamento")
public class GrupoMedicamentoController {

	
	
	@Autowired
	private GrupoMedicamentoServiceImpl grupoMedicamentoService;

	// Gera todos os elementos do GrupoMedicamentos
	@GetMapping("/grupo")
	public List<GrupoMedicamentoDto> getGrupoMedicamento() {
		return GrupoMedicamentoDto.converter(grupoMedicamentoService.imprimi());
	}
	
	// Insere um elemento
	@PostMapping("/grupo")
	@Transactional
	public GrupoMedicamentoDto Cadastrar(@RequestBody @Validated AtualizacaoGrupoForm form) {
		GrupoMedicamentoEntity grupoMedicamento = grupoMedicamentoService.insercao(form);
		return new GrupoMedicamentoDto(grupoMedicamento);
	}
	
	// Busca o elemento pelo id
	@GetMapping("/grupo/{id}")
	public ResponseEntity<GrupoMedicamentoDto> detalhar(@PathVariable Long id) {
		ResponseEntity<GrupoMedicamentoDto> grupo = grupoMedicamentoService.detalhaId(id);
		return grupo;
	}
	
	// Atualiza o elemento
	@PutMapping("/grupo/{id}")
	@Transactional
	public ResponseEntity<GrupoMedicamentoDto> atualizacao(@PathVariable Long id,  @RequestBody @Validated GrupoMedicamentoForm form) {
		GrupoMedicamentoEntity grupoMedicamento = grupoMedicamentoService.atualizar(id, form);
		return ResponseEntity.ok(new GrupoMedicamentoDto(grupoMedicamento));
	}
	
	// Remove do Banco de Dados
	@DeleteMapping("{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {
		 ResponseEntity<?> grupo = grupoMedicamentoService.remover(id);
		 return grupo;
		
	}
	
}
