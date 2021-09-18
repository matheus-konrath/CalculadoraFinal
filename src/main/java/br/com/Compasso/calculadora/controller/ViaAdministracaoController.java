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
import br.com.Compasso.calculadora.dto.ViaAdministracaoDto;
import br.com.Compasso.calculadora.form.AtualizaViaAdmForm;
import br.com.Compasso.calculadora.form.ViaAdministracaoForm;
import br.com.Compasso.calculadora.modelo.ViaAdministracaoEntity;
import br.com.Compasso.calculadora.service.ViaAdministracaoServiceImpl;
import io.swagger.annotations.Api;



@RestController
@ResponseBody
@Api(value = "viaAdministracao")
@RequestMapping("/viaAdministracao")
public class ViaAdministracaoController {

	@Autowired
	private ViaAdministracaoServiceImpl viaAdministracaoService;
	
	// Gera todos os elementos do GrupoMedicamentos
	@GetMapping("/via")
	public List<ViaAdministracaoDto> getviaAdm() {
		return ViaAdministracaoDto.conve(viaAdministracaoService.listar());
	}
	
	@PostMapping("/via")
	@Transactional
	public ViaAdministracaoDto Cadastrar(@RequestBody @Validated ViaAdministracaoForm form) {
		ViaAdministracaoEntity viaAdm = viaAdministracaoService.inserir(form);
		return new ViaAdministracaoDto(viaAdm);
	}
	
	
	@PutMapping("/medi/{id}")
	@Transactional
	public ResponseEntity<ViaAdministracaoDto> atualiza(@PathVariable BigInteger id,  @RequestBody @Validated AtualizaViaAdmForm form) {
		ViaAdministracaoEntity viaAdm = viaAdministracaoService.altera(id, form);
		return ResponseEntity.ok(new ViaAdministracaoDto(viaAdm));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> remover(@PathVariable BigInteger id) {
		 ResponseEntity<?> viaAdm = viaAdministracaoService.retirar(id);
		 return viaAdm;
		
	}


}
