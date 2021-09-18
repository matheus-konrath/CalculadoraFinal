package br.com.Compasso.calculadora.service;

import java.math.BigInteger;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.Compasso.calculadora.dto.DiluicaoDto;
import br.com.Compasso.calculadora.form.DiluicaoForm;
import br.com.Compasso.calculadora.form.MedicamentoForm;
import br.com.Compasso.calculadora.modelo.DiluicaoConfiguracaoEntity;
import br.com.Compasso.calculadora.modelo.DiluicaoConfiguracaoEntityPK;
import br.com.Compasso.calculadora.modelo.MedicamentoEntity;
import br.com.Compasso.calculadora.modelo.ViaAdministracaoEntity;
import br.com.Compasso.calculadora.repositorio.DiluicaoConfiguracaoRepositorio;
import br.com.Compasso.calculadora.repositorio.MedicamentoRepositorio;
import br.com.Compasso.calculadora.repositorio.ViaAdministracaoRepositorio;

@Service
public class DiluicaoServiceImpl {

	@Autowired
	private DiluicaoConfiguracaoRepositorio diluicaoRepositorio;
	private ViaAdministracaoRepositorio viaAdministracaoRepositorio;
	private MedicamentoRepositorio medicamentoRepositorio;
	
	//busca elementos do grupoMedicamentos inseridos  #GET
		public ResponseEntity<List<DiluicaoDto>> lista() {
			List<DiluicaoConfiguracaoEntity> diluicao = diluicaoRepositorio.findAll();
			List<DiluicaoDto> diluicaoList = new ArrayList<DiluicaoDto>();

			diluicao.forEach(dilui -> {
				diluicaoList.add(new DiluicaoDto(dilui));
			});

			return ResponseEntity.ok(diluicaoList);
		}
		
/*		// POST insere no Banco de dados
		public ResponseEntity<DiluicaoDto> criar(DiluicaoForm diluicaoConfiguracaoForm,
				UriComponentsBuilder uriBuilder) {
			if ((medicamentoRepositorio.findById(diluicaoConfiguracaoForm.getMedicamentoId()) == null)
					|| (viaAdministracaoRepositorio.findById(diluicaoConfiguracaoForm.getViaAdministracaoId()) == null)) {
				throw new RuntimeException();
			} else {
				Optional<MedicamentoEntity> medicamento = medicamentoRepositorio
						.findById(diluicaoConfiguracaoForm.getMedicamentoId());
				Optional<ViaAdministracaoEntity> viaAdministracao = viaAdministracaoRepositorio
						.findById(diluicaoConfiguracaoForm.getViaAdministracaoId());

				DiluicaoConfiguracaoEntity diluicaoConfiguracao = new OperacoesService().diluicaoFormToDiluicaoConfiguracao(
						diluicaoConfiguracaoForm, medicamento.get(), viaAdministracao.get());
				diluicaoRepositorio.save(diluicaoConfiguracao);

				URI uri = uriBuilder.path("/criar/{id}").buildAndExpand(diluicaoConfiguracao.getDiluicaoConfiguracaoPK())
						.toUri();
				return ResponseEntity.created(uri).body(new DiluicaoDto(diluicaoConfiguracao));
			}
		}
	*/	
		
		public ResponseEntity<DiluicaoDto> excluir(BigInteger medicamentoId, BigInteger viaAdministracaoId,
				BigInteger sequencia) {
			MedicamentoEntity medicamento = medicamentoRepositorio.getById(medicamentoId);
			ViaAdministracaoEntity viaAdministracao = viaAdministracaoRepositorio.getById(viaAdministracaoId);
			DiluicaoConfiguracaoEntityPK diluicaoConfiguracaoPK = new DiluicaoConfiguracaoEntityPK(medicamento, viaAdministracao,
					sequencia);

			if (!diluicaoRepositorio.existsById(diluicaoConfiguracaoPK)) {
				throw new RuntimeException();
			} else {
				try {
					Optional<DiluicaoConfiguracaoEntity> diluicaoConfiguracao = diluicaoRepositorio
							.findById(diluicaoConfiguracaoPK);
					DiluicaoDto diluicaoConfiguracaoDto = new DiluicaoDto(
							diluicaoConfiguracao.get());
					diluicaoRepositorio.deleteById(diluicaoConfiguracaoPK);
					return (ResponseEntity.ok(diluicaoConfiguracaoDto));
				} catch (RuntimeException exception) {
					throw exception;
				}
			}
		}
		
		
}
