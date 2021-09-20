package br.com.Compasso.calculadora.service;

import java.math.BigInteger;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.Compasso.calculadora.dto.DiluicaoDto;
import br.com.Compasso.calculadora.dto.MedicamentoConfiguracaoDto;
import br.com.Compasso.calculadora.dto.MedicamentoDto;
import br.com.Compasso.calculadora.dto.RecordNotFoundException;
import br.com.Compasso.calculadora.form.AtualizaMedicamentoForm;
import br.com.Compasso.calculadora.form.DiluicaoConfiguracaoAtualizarForm;
import br.com.Compasso.calculadora.form.DiluicaoForm;
import br.com.Compasso.calculadora.form.MedicamentoConfiguraForm;
import br.com.Compasso.calculadora.form.MedicamentoForm;
import br.com.Compasso.calculadora.modelo.DiluicaoConfiguracaoEntity;
import br.com.Compasso.calculadora.modelo.GrupoMedicamentoEntity;
import br.com.Compasso.calculadora.modelo.LaboratorioEntity;
import br.com.Compasso.calculadora.modelo.MedicamentoEntity;
import br.com.Compasso.calculadora.modelo.ViaAdministracaoEntity;
import br.com.Compasso.calculadora.repositorio.DiluicaoConfiguracaoRepositorio;
import br.com.Compasso.calculadora.repositorio.GrupoMedicamentoRepositorio;
import br.com.Compasso.calculadora.repositorio.LaboratorioRepositorio;
import br.com.Compasso.calculadora.repositorio.MedicamentoRepositorio;
import br.com.Compasso.calculadora.repositorio.ViaAdministracaoRepositorio;

@Service
public class MedicamentoServiceImpl {
	
	
	@Autowired
    MedicamentoRepositorio medicamentoRepositorio;
	LaboratorioRepositorio laboratorioRepositorio;
	GrupoMedicamentoRepositorio grupoMedicamentoRepositorio;
	ViaAdministracaoRepositorio viaAdministracaoRepositorio;
	DiluicaoConfiguracaoRepositorio diluicaoRepositorio;
	
	
	public MedicamentoServiceImpl(MedicamentoRepositorio medicamentoRepositorio, LaboratorioRepositorio laboratorioRepositorio,
			GrupoMedicamentoRepositorio grupoMedicamentoRepositorio, ViaAdministracaoRepositorio viaAdministracaoRepositorio,
			DiluicaoConfiguracaoRepositorio diluicaoConfiguracaoRepositorio) {
		
		this.medicamentoRepositorio = medicamentoRepositorio;
		this.laboratorioRepositorio = laboratorioRepositorio;
		this.grupoMedicamentoRepositorio = grupoMedicamentoRepositorio;
		this.viaAdministracaoRepositorio = viaAdministracaoRepositorio;
		this.diluicaoRepositorio = diluicaoConfiguracaoRepositorio;
	}
	
	

	//busca elementos do grupoMedicamentos inseridos  #GET
	public ResponseEntity<List<MedicamentoDto>> lista() {
		List<MedicamentoEntity> medicamento = medicamentoRepositorio.findAll();
		if(medicamento == null) {
			throw new RecordNotFoundException("Medicamento não encontrado");
		}
		List<MedicamentoDto> MedicamentoList = new ArrayList<MedicamentoDto>();

		medicamento.forEach(med -> {
			MedicamentoList.add(new MedicamentoDto(med));
		});

		return ResponseEntity.ok(MedicamentoList);
	}

	// GET por id, busca pelo id
	public ResponseEntity<MedicamentoDto> detalhaId(BigInteger id) {
		Optional<MedicamentoEntity> medicamento = medicamentoRepositorio.findById(id);
		if (medicamento.isPresent()) { // Verifica se tem
			return ResponseEntity.ok(new MedicamentoDto(medicamentoRepositorio.getById(id)));
		}

		 throw new RecordNotFoundException("Id do medicamento não encontrado"); // Não encontrado
	}


	
	@Transactional
	//Método POST   cria um elemento
	public ResponseEntity<MedicamentoConfiguracaoDto> criar(MedicamentoConfiguraForm medicamentoConfiguracaoForm,
			UriComponentsBuilder uriBuilder) {
		if ((grupoMedicamentoRepositorio.findById(medicamentoConfiguracaoForm.getIdGrupoMedicamento()) == null)
				|| (laboratorioRepositorio.findById(medicamentoConfiguracaoForm.getIdLaboratorio()) == null)) {
			throw new RecordNotFoundException("O id não foi encontrado");
		} else {
			//Busca pelo Grupo Medicamento
			Optional<GrupoMedicamentoEntity> grupoMedicamento = grupoMedicamentoRepositorio
					.findById(medicamentoConfiguracaoForm.getIdGrupoMedicamento());
			//Busca pelo id do Laboratroio
			Optional<LaboratorioEntity> laboratorio = laboratorioRepositorio
					.findById(medicamentoConfiguracaoForm.getIdLaboratorio());
			MedicamentoEntity medicamento = new OperacoesService().medicamentoConfiguracaoFormToMedicamento(
					medicamentoConfiguracaoForm, laboratorio.get(), grupoMedicamento.get());

			medicamentoRepositorio.save(medicamento);
			

			List<DiluicaoConfiguracaoAtualizarForm> diluicaoConfiguracaoFormList = medicamentoConfiguracaoForm
					.getDiluicaoConfiguracaoList();
			List<DiluicaoDto> diluicaoConfiguracaoList = new ArrayList<>();
			if (!diluicaoConfiguracaoFormList.isEmpty()) {
				for (DiluicaoConfiguracaoAtualizarForm diluicaoConfiguracaoForm : diluicaoConfiguracaoFormList) {
					Optional<ViaAdministracaoEntity> viaAdministracao = viaAdministracaoRepositorio
							.findById(diluicaoConfiguracaoForm.getViaAdministracaoId());

					DiluicaoConfiguracaoEntity diluicaoConfiguracao = new OperacoesService()
							.diluicaoFormToDiluicaoConfiguracao(diluicaoConfiguracaoForm, medicamento,
									viaAdministracao.get());
					diluicaoRepositorio.save(diluicaoConfiguracao);
					diluicaoConfiguracaoList.add(new DiluicaoDto(diluicaoConfiguracao));
			}
			}

			URI uri = uriBuilder.path("/criar").buildAndExpand(medicamento.getId()).toUri();
			return ResponseEntity.created(uri)
					.body(new MedicamentoConfiguracaoDto(medicamento, diluicaoConfiguracaoList));
		}
	}
	
	
	
	

	@Transactional
	// Método Put atualiza um elemento
	public ResponseEntity<MedicamentoConfiguracaoDto> atualiza(BigInteger id,
			MedicamentoConfiguraForm medicamentoConfiguracaoForm) {
		BigInteger idGrupoMedicamento = medicamentoConfiguracaoForm.getIdGrupoMedicamento();
		MedicamentoEntity medicamentos = medicamentoRepositorio.getById(id);
		BigInteger idLaboratorio = medicamentoConfiguracaoForm.getIdLaboratorio();
		if (!medicamentoRepositorio.existsById(id)
				|| (grupoMedicamentoRepositorio.findById(medicamentoConfiguracaoForm.getIdGrupoMedicamento()) == null)
				|| (laboratorioRepositorio.findById(medicamentoConfiguracaoForm.getIdLaboratorio()) == null)) {
			throw new RecordNotFoundException("O id não foi encontrado");
		} else {
			try {
				MedicamentoEntity medicamento = new OperacoesService().medicamentoFormToMedicamento(id,
						medicamentoConfiguracaoForm, medicamentoRepositorio, grupoMedicamentoRepositorio,
						laboratorioRepositorio);

				List<DiluicaoConfiguracaoAtualizarForm> diluicaoConfiguracaoFormList = medicamentoConfiguracaoForm
						.getDiluicaoConfiguracaoList();
				List<DiluicaoDto> diluicaoConfiguracaoList = new ArrayList<>();
				if (!diluicaoConfiguracaoFormList.isEmpty()) {
					for (DiluicaoConfiguracaoAtualizarForm diluicaoConfiguracaoForm : diluicaoConfiguracaoFormList) {
						
						DiluicaoConfiguracaoEntity diluicaoConfiguracao = new OperacoesService()
								.diluicaoAtualizarFormToDiluicao(medicamento.getId(),
										diluicaoConfiguracaoForm.getViaAdministracaoId(),
										diluicaoConfiguracaoForm.getSequencia(), diluicaoConfiguracaoForm,
										medicamentoRepositorio, viaAdministracaoRepositorio,
										diluicaoRepositorio);
						diluicaoConfiguracaoList.add(new DiluicaoDto(diluicaoConfiguracao));
					}
				}
				return (ResponseEntity.ok(new MedicamentoConfiguracaoDto(medicamento, diluicaoConfiguracaoList)));
			} catch (RuntimeException exception) {
				throw exception;
			}
		}
	}
	

	// DELETE remove o elemento do Banco de dados
	public ResponseEntity<?> excluir(BigInteger id) {
		Optional<MedicamentoEntity> medicamento = medicamentoRepositorio.findById(id);
		if (medicamento.isPresent()) {
			medicamentoRepositorio.deleteById(id); // remove pelo id
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}

