package br.com.Compasso.calculadora.controller;


import java.math.BigInteger;
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
import org.springframework.web.util.UriComponentsBuilder;

import br.com.Compasso.calculadora.dto.MedicamentoConfiguracaoDto;
import br.com.Compasso.calculadora.dto.MedicamentoDto;
import br.com.Compasso.calculadora.form.AtualizaMedicamentoForm;
import br.com.Compasso.calculadora.form.MedicamentoConfiguraForm;
import br.com.Compasso.calculadora.form.MedicamentoForm;
import br.com.Compasso.calculadora.modelo.MedicamentoEntity;
import br.com.Compasso.calculadora.service.MedicamentoServiceImpl;
import io.swagger.annotations.Api;

@RestController
@ResponseBody
@Api(value = "medicamento")
@RequestMapping("/medicamento")
public class MedicamentoController {

	

	@Autowired
	private MedicamentoServiceImpl medicamentoService;

	@GetMapping("/medi")
	public ResponseEntity<List<MedicamentoDto>> lista() {
		return (medicamentoService.lista());
	}


	
	@PostMapping("/medi")
	@Transactional
	public ResponseEntity<MedicamentoConfiguracaoDto> criar(@RequestBody MedicamentoConfiguraForm medicamentoConfiguracaoForm,
			UriComponentsBuilder uriBuilder) {
		return medicamentoService.criar(medicamentoConfiguracaoForm, uriBuilder);
	}

	@GetMapping("/medi/{id}")
	public ResponseEntity<MedicamentoDto> detalhar(@PathVariable BigInteger id) {
		ResponseEntity<MedicamentoDto> medicamento = medicamentoService.detalhaId(id);
		return medicamento;
	}

	@PutMapping("/medi/{id}")
	@Transactional
	public ResponseEntity<MedicamentoConfiguracaoDto> atualizar(@PathVariable BigInteger id, @RequestBody MedicamentoConfiguraForm medicamentoConfiguraForm) {
		return (medicamentoService.atualiza(id, medicamentoConfiguraForm));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> remover(@PathVariable BigInteger id) {
		 ResponseEntity<?> medicamento = medicamentoService.excluir(id);
		 return medicamento;
		
	}
	
}


