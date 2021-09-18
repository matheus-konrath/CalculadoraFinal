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
import br.com.Compasso.calculadora.form.AtualizaMedicamentoForm;
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

		return ResponseEntity.notFound().build(); // Não encontrado
	}


	
	@Transactional
	public ResponseEntity<MedicamentoConfiguracaoDto> criar(MedicamentoConfiguraForm medicamentoConfiguracaoForm,
			UriComponentsBuilder uriBuilder) {
		if ((grupoMedicamentoRepositorio.findById(medicamentoConfiguracaoForm.getIdGrupoMedicamento()) == null)
				|| (laboratorioRepositorio.findById(medicamentoConfiguracaoForm.getIdLaboratorio()) == null)) {
			throw new RuntimeException();
		} else {
			Optional<LaboratorioEntity> laboratorio = laboratorioRepositorio
					.findById(medicamentoConfiguracaoForm.getIdLaboratorio());
			Optional<GrupoMedicamentoEntity> grupoMedicamento = grupoMedicamentoRepositorio
					.findById(medicamentoConfiguracaoForm.getIdGrupoMedicamento());
			MedicamentoEntity medicamento = new OperacoesService().medicamentoConfiguracaoFormToMedicamento(
					medicamentoConfiguracaoForm, laboratorio.get(), grupoMedicamento.get());

			medicamentoRepositorio.save(medicamento);
			// BigInteger idMedicamento = medicamento.getId();

			List<DiluicaoForm> diluicaoConfiguracaoFormList = medicamentoConfiguracaoForm
					.getDiluicaoConfiguracao();
			List<DiluicaoDto> diluicaoConfiguracaoList = new ArrayList<>();
			if (!diluicaoConfiguracaoFormList.isEmpty()) {
				for (DiluicaoForm diluicaoConfiguracaoForm : diluicaoConfiguracaoFormList) {
					Optional<ViaAdministracaoEntity> viaAdministracao = viaAdministracaoRepositorio
							.findById(diluicaoConfiguracaoForm.getViaAdministracaoId());

					DiluicaoConfiguracaoEntity diluicaoConfiguracao = new OperacoesService()
							.diluicaoFormToDiluicaoConfiguracao(diluicaoConfiguracaoForm, medicamento,
									viaAdministracao.get());
					diluicaoRepositorio.save(diluicaoConfiguracao);
					diluicaoConfiguracaoList.add(new DiluicaoDto(diluicaoConfiguracao));
				}
			}

			URI uri = uriBuilder.path("/criar/{id}").buildAndExpand(medicamento.getId()).toUri();
			return ResponseEntity.created(uri)
					.body(new MedicamentoConfiguracaoDto(medicamento, diluicaoConfiguracaoList));
		}
	}
	
	
	
	

	@Transactional
	public ResponseEntity<MedicamentoConfiguracaoDto> atualiza(BigInteger id,
			MedicamentoConfiguraForm medicamentoConfiguracaoForm) {
		if (!medicamentoRepositorio.existsById(id)
				|| (grupoMedicamentoRepositorio.findById(medicamentoConfiguracaoForm.getIdGrupoMedicamento()) == null)
				|| (laboratorioRepositorio.findById(medicamentoConfiguracaoForm.getIdLaboratorio()) == null)) {
			throw new RuntimeException();
		} else {
			try {
				MedicamentoEntity medicamento = new OperacoesService().medicamentoFormToMedicamento(id,
						medicamentoConfiguracaoForm, medicamentoRepositorio, grupoMedicamentoRepositorio,
						laboratorioRepositorio);

				List<DiluicaoForm> diluicaoFormList = medicamentoConfiguracaoForm
						.getDiluicaoConfiguracao();
				List<DiluicaoDto> diluicaoConfiguracaoList = new ArrayList<>();
				if (!diluicaoFormList.isEmpty()) {
					for (DiluicaoForm diluicaoConfiguracaoForm : diluicaoFormList) {
						
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

