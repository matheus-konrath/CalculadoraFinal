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
import br.com.Compasso.calculadora.dto.MedicamentoDto;
import br.com.Compasso.calculadora.form.AtualizaMedicamentoForm;
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
	public List<MedicamentoDto> getMedicamento() {
		return MedicamentoDto.converter(medicamentoService.imprimi());
	}

	@PostMapping("/medi")
	@Transactional
	public MedicamentoDto Cadastrar(@RequestBody @Validated MedicamentoForm form) {
		MedicamentoEntity medicamento = medicamentoService.inser(form);
		return new MedicamentoDto(medicamento);
	}

	@GetMapping("/medi/{id}")
	public ResponseEntity<MedicamentoDto> detalhar(@PathVariable Long id) {
		ResponseEntity<MedicamentoDto> medicamento = medicamentoService.detalhaId(id);
		return medicamento;
	}

	@PutMapping("/medi/{id}")
	@Transactional
	public ResponseEntity<MedicamentoDto> atualizacao(@PathVariable Long id,  @RequestBody @Validated AtualizaMedicamentoForm form) {
		MedicamentoEntity medicamento = medicamentoService.altera(id, form);
		return ResponseEntity.ok(new MedicamentoDto(medicamento));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {
		 ResponseEntity<?> medicamento = medicamentoService.retirar(id);
		 return medicamento;
		
	}
	
}


