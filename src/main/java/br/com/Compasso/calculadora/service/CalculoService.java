package br.com.Compasso.calculadora.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.Compasso.calculadora.dto.HistoricoDto;
import br.com.Compasso.calculadora.form.CalculadoraForm;
import br.com.Compasso.calculadora.modelo.DiluicaoConfiguracaoEntity;
import br.com.Compasso.calculadora.modelo.HistoricoEntity;
import br.com.Compasso.calculadora.modelo.MedicamentoEntity;
import br.com.Compasso.calculadora.modelo.ViaAdministracaoEntity;
import br.com.Compasso.calculadora.repositorio.DiluicaoConfiguracaoRepositorio;
import br.com.Compasso.calculadora.repositorio.HistoricoRespositorio;
import br.com.Compasso.calculadora.repositorio.MedicamentoRepositorio;
import br.com.Compasso.calculadora.repositorio.ViaAdministracaoRepositorio;

@Service
public class CalculoService {

	private DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //Formatador de Datas
			
	
	HistoricoRespositorio historicoRepositorio;
	MedicamentoRepositorio medicamentoRepositorio;
	ViaAdministracaoRepositorio viaRepositorioRepositorio;
	DiluicaoConfiguracaoRepositorio diluicaoRepositorio;
	
	
	
	public CalculoService(HistoricoRespositorio historicoRepositorio, MedicamentoRepositorio medicamentoRepositorio,
			ViaAdministracaoRepositorio viaRepositorioRepositorio,
			DiluicaoConfiguracaoRepositorio diluicaoRepositorio) {
		this.historicoRepositorio = historicoRepositorio;
		this.medicamentoRepositorio = medicamentoRepositorio;
		this.viaRepositorioRepositorio = viaRepositorioRepositorio;
		this.diluicaoRepositorio = diluicaoRepositorio;
	}
	
	//Lista os valores do Historico
	public ResponseEntity<List<HistoricoDto>> listar(BigInteger id, String dataInicio, String dataFim){
		List<HistoricoDto> historicoDto = new ArrayList<HistoricoDto>();
		// data inicial
		LocalDate dataInicial = LocalDate.parse(dataInicio, formatador);
		// data Final
		LocalDate dataFinal = LocalDate.parse(dataFim, formatador);
		// Busca pelo id do Medicamento
		Optional<MedicamentoEntity> medicamento = medicamentoRepositorio.findById(id);
		if(!medicamento.isPresent()) {
			throw new RuntimeException("Não encotrado");
		}
		
		String nomeMedicamento = medicamento.get().getNome();
		List<HistoricoEntity> historico = historicoRepositorio.findByNomeAndBetweenDatas(nomeMedicamento, dataInicial, dataFinal);
		historico.forEach(histo ->{
			historicoDto.add(new HistoricoDto(histo));
		});
		
		return ResponseEntity.ok(historicoDto);
		
	}
	
	
	public ResponseEntity<HistoricoDto> criar(CalculadoraForm calForm){
		BigInteger idViaAdministracao = calForm.getIdViaAdministracao();
		BigInteger idMedicamento = calForm.getIdMedicamento();
		//Busca pelo id do Medicamento
		Optional<MedicamentoEntity> medicamento = medicamentoRepositorio.findById(idMedicamento);
		if(!medicamento.isPresent()) {
			throw new RuntimeException("Não encontrado");
		}
		//Buscar pelo ViaAdministração
		Optional<ViaAdministracaoEntity> via = viaRepositorioRepositorio.findById(idViaAdministracao);
		if(!via.isPresent()) {
			throw new RuntimeException("Id da via não encontrada");
		}
		
		List<DiluicaoConfiguracaoEntity> diluicao = diluicaoRepositorio.findDiluicaoConfiguracaoViaMed(idViaAdministracao, idMedicamento);
		
		BigDecimal prescricao = calForm.getPrescricao();
		BigDecimal conta = prescricao.divide(medicamento.get().getQuantidadeApresentacao());
		
		System.out.println(conta);
		return ResponseEntity.ok().build();
		
	}
	
	
	
	
	
}
