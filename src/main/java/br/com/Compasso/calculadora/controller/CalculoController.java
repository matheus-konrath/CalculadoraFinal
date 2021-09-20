package br.com.Compasso.calculadora.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.Compasso.calculadora.dto.HistoricoDto;
import br.com.Compasso.calculadora.form.CalculadoraForm;
import br.com.Compasso.calculadora.service.CalculoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/calculo")
public class CalculoController {

	CalculoService calculoService;
	
	
	@Autowired
	public CalculoController(CalculoService calculoService) {
		this.calculoService = calculoService;
	}
	
	
	
	
	
	@GetMapping("/calc")
	public ResponseEntity<List<HistoricoDto>> lista(@RequestParam BigInteger id, @RequestParam String dataInicio,
			@RequestParam String dataFim) {
		return (calculoService.listar(id, dataInicio, dataFim));
	}
	
	
	@PostMapping("/calc")
	public ResponseEntity<HistoricoDto>postar(@RequestBody CalculadoraForm calcform){
		return (calculoService.criar(calcform));
	}


	
	
	
}
