package br.com.Compasso.calculadora.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.Compasso.calculadora.dto.DiluicaoDto;
import br.com.Compasso.calculadora.form.DiluicaoForm;
import br.com.Compasso.calculadora.service.DiluicaoServiceImpl;
import io.swagger.annotations.Api;

@RestController
@ResponseBody
@Api(value = "diluicaoConfiguracao")
@RequestMapping("/diluicaoConfiguracao")
public class DiluicaoController {
	
	@Autowired
	private DiluicaoServiceImpl diluicaoService;
	
	
	@GetMapping("/diluicao")
	public ResponseEntity<List<DiluicaoDto>>mostrar(){
		return diluicaoService.lista();
	}
	
/*	@PostMapping("/diluicao")
	public ResponseEntity<DiluicaoDto> criar(@RequestBody DiluicaoForm diluicaoForm, UriComponentsBuilder uriBuilder ){
		return diluicaoService.criar(diluicaoForm, uriBuilder );
	}
*/
	
	@DeleteMapping("/diluicao")
	public ResponseEntity<DiluicaoDto> deletar(@PathVariable BigInteger medicamentoId, @PathVariable BigInteger viaAdministracaoId, @PathVariable BigInteger sequencia) {
		return diluicaoService.excluir(medicamentoId,viaAdministracaoId,sequencia);
	}
}
