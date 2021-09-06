package br.com.Compasso.calculadora.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.Compasso.calculadora.controller.dto.MedicamentoDto;
import br.com.Compasso.calculadora.modelo.GrupoMedicamentos;

import br.com.Compasso.calculadora.repositorio.MedicamentoRepositorio;

@RestController
@ResponseBody
@RequestMapping("/medicamentos")
public class MedicamentoController{

	
	
	
	@Autowired
	private MedicamentoRepositorio	medicamentoRepositorio;
	

	
	
	@GetMapping
	public List<MedicamentoDto>getMedicamento(){
		List<GrupoMedicamentos> medicamento = (List<GrupoMedicamentos>) medicamentoRepositorio.findAll();
		return MedicamentoDto.converter(medicamento);
		
	}
	
	
 
}
