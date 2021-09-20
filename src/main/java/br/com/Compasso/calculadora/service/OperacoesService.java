package br.com.Compasso.calculadora.service;

import java.math.BigInteger;

import br.com.Compasso.calculadora.form.DiluicaoConfiguracaoAtualizarForm;
import br.com.Compasso.calculadora.form.DiluicaoForm;
import br.com.Compasso.calculadora.form.MedicamentoConfiguraForm;
import br.com.Compasso.calculadora.form.MedicamentoForm;
import br.com.Compasso.calculadora.modelo.DiluicaoConfiguracaoEntity;
import br.com.Compasso.calculadora.modelo.DiluicaoConfiguracaoEntityPK;
import br.com.Compasso.calculadora.modelo.GrupoMedicamentoEntity;
import br.com.Compasso.calculadora.modelo.LaboratorioEntity;
import br.com.Compasso.calculadora.modelo.MedicamentoEntity;
import br.com.Compasso.calculadora.modelo.ViaAdministracaoEntity;
import br.com.Compasso.calculadora.repositorio.DiluicaoConfiguracaoRepositorio;
import br.com.Compasso.calculadora.repositorio.GrupoMedicamentoRepositorio;
import br.com.Compasso.calculadora.repositorio.LaboratorioRepositorio;
import br.com.Compasso.calculadora.repositorio.MedicamentoRepositorio;
import br.com.Compasso.calculadora.repositorio.ViaAdministracaoRepositorio;

public class OperacoesService {

	public MedicamentoEntity medicamentoConfiguracaoFormToMedicamento(MedicamentoConfiguraForm medicamentoConfiguracaoForm,
			LaboratorioEntity laboratorio, GrupoMedicamentoEntity grupoMedicamento) {
		MedicamentoEntity medicamento = new MedicamentoEntity();
		medicamento.setNome(medicamentoConfiguracaoForm.getNome());
		medicamento.setLaboratorio(laboratorio);
		medicamento.setGrupoMedicamento(grupoMedicamento);
		medicamento.setConcentracaoInicial(medicamentoConfiguracaoForm.getConcentracaoInicial());
		medicamento.setEmbalagemApresentada(medicamentoConfiguracaoForm.getEmbalagemApresentada());
		medicamento.setInfoObservacao(medicamentoConfiguracaoForm.getInfoObservacao());
		medicamento.setInfoSobra(medicamentoConfiguracaoForm.getInfoSobra());
		medicamento.setInfoTempoAdministracao(medicamentoConfiguracaoForm.getInfoTempoAdministracao());
		medicamento.setQuantidadeApresentacao(medicamentoConfiguracaoForm.getQuantidadeApresentacao());
		medicamento.setUnidadeMedida(medicamentoConfiguracaoForm.getUnidadeMedida());
		return medicamento;
	}
	

	public MedicamentoEntity medicamentoFormMedicamento(MedicamentoForm medicamentoForm, LaboratorioEntity laboratorio,
			GrupoMedicamentoEntity grupoMedicamento) {
		MedicamentoEntity medicamento = new MedicamentoEntity();
		medicamento.setNome(medicamentoForm.getNome());
		medicamento.setLaboratorio(laboratorio);
		medicamento.setGrupoMedicamento(grupoMedicamento);
		medicamento.setConcentracaoInicial(medicamentoForm.getConcentracaoInicial());
		medicamento.setEmbalagemApresentada(medicamentoForm.getEmbalagemApresentada());
		medicamento.setInfoObservacao(medicamentoForm.getInfoObservacao());
		medicamento.setInfoSobra(medicamentoForm.getInfoSobra());
		medicamento.setInfoTempoAdministracao(medicamentoForm.getInfoTempoAdministracao());
		medicamento.setQuantidadeApresentacao(medicamentoForm.getQuantidadeApresentacao());
		medicamento.setUnidadeMedida(medicamentoForm.getUnidadeMedida());
		return medicamento;
	}

	public MedicamentoEntity medicamentoFormToMedicamento(BigInteger id, MedicamentoForm medicamentoForm,
			MedicamentoRepositorio medicamentoRepository, GrupoMedicamentoRepositorio grupoMedicamentoRepository,
			LaboratorioRepositorio laboratorioRepository) {

		MedicamentoEntity medicamento = medicamentoRepository.getById(id);
		LaboratorioEntity laboratorio = laboratorioRepository.getById(medicamentoForm.getIdLaboratorio());
		GrupoMedicamentoEntity grupoMedicamento = grupoMedicamentoRepository.getById(medicamentoForm.getIdGrupoMedicamento());

		medicamento.setNome(medicamentoForm.getNome());
		medicamento.setLaboratorio(laboratorio);
		medicamento.setGrupoMedicamento(grupoMedicamento);
		medicamento.setConcentracaoInicial(medicamentoForm.getConcentracaoInicial());
		medicamento.setEmbalagemApresentada(medicamentoForm.getEmbalagemApresentada());
		medicamento.setInfoObservacao(medicamentoForm.getInfoObservacao());
		medicamento.setInfoSobra(medicamentoForm.getInfoSobra());
		medicamento.setInfoTempoAdministracao(medicamentoForm.getInfoTempoAdministracao());
		medicamento.setQuantidadeApresentacao(medicamentoForm.getQuantidadeApresentacao());
		medicamento.setUnidadeMedida(medicamentoForm.getUnidadeMedida());
		return medicamento;
	}
	
	public MedicamentoEntity medicamentoFormToMedicamento(BigInteger id, MedicamentoConfiguraForm medicamentoConfiguracaoForm,
			MedicamentoRepositorio medicamentoRepository, GrupoMedicamentoRepositorio grupoMedicamentoRepository,
			LaboratorioRepositorio laboratorioRepository) {

		MedicamentoEntity medicamento = medicamentoRepository.getById(id);
		LaboratorioEntity laboratorio = laboratorioRepository.getById(medicamentoConfiguracaoForm.getIdLaboratorio());
		GrupoMedicamentoEntity grupoMedicamento = grupoMedicamentoRepository.getById(medicamentoConfiguracaoForm.getIdGrupoMedicamento());

		medicamento.setNome(medicamentoConfiguracaoForm.getNome());
		medicamento.setLaboratorio(laboratorio);
		medicamento.setGrupoMedicamento(grupoMedicamento);
		medicamento.setConcentracaoInicial(medicamentoConfiguracaoForm.getConcentracaoInicial());
		medicamento.setEmbalagemApresentada(medicamentoConfiguracaoForm.getEmbalagemApresentada());
		medicamento.setInfoObservacao(medicamentoConfiguracaoForm.getInfoObservacao());
		medicamento.setInfoSobra(medicamentoConfiguracaoForm.getInfoSobra());
		medicamento.setInfoTempoAdministracao(medicamentoConfiguracaoForm.getInfoTempoAdministracao());
		medicamento.setQuantidadeApresentacao(medicamentoConfiguracaoForm.getQuantidadeApresentacao());
		medicamento.setUnidadeMedida(medicamentoConfiguracaoForm.getUnidadeMedida());
		return medicamento;
	}

	public DiluicaoConfiguracaoEntity diluicaoFormToDiluicaoConfiguracao(DiluicaoForm diluicaoConfiguracaoForm,
			MedicamentoEntity medicamento, ViaAdministracaoEntity viaAdministracao) {
		DiluicaoConfiguracaoEntity diluicaoConfiguracao = new DiluicaoConfiguracaoEntity();
		diluicaoConfiguracao.setDiluicaoConfiguracaoPK(medicamento, viaAdministracao,
				diluicaoConfiguracaoForm.getSequencia());
		// diluicaoConfiguracao.setSequencia(diluicaoConfiguracaoForm.getSequencia());
		// diluicaoConfiguracao.setMedicamento(medicamento);
		// diluicaoConfiguracao.setViaAdministracao(viaAdministracao);
		diluicaoConfiguracao.setQuantidadeAspirada(diluicaoConfiguracaoForm.getQuantidadeAspirada());
		diluicaoConfiguracao.setQuantidadeAdicionada(diluicaoConfiguracaoForm.getQuantidadeAdicionada());
		diluicaoConfiguracao.setConcentracao(diluicaoConfiguracaoForm.getConcentracao());
		diluicaoConfiguracao.setModoPreparo(diluicaoConfiguracaoForm.getModoPreparo());
		diluicaoConfiguracao.setDiluente(diluicaoConfiguracaoForm.getDiluente());
		return diluicaoConfiguracao;
	}

	public DiluicaoConfiguracaoEntity diluicaoFormToDiluicaoConfiguracao(
			DiluicaoConfiguracaoAtualizarForm diluicaoConfiguracaoForm, MedicamentoEntity medicamento,
			ViaAdministracaoEntity viaAdministracao) {
		DiluicaoConfiguracaoEntity diluicaoConfiguracao = new DiluicaoConfiguracaoEntity();
		diluicaoConfiguracao.setDiluicaoConfiguracaoPK(medicamento, viaAdministracao,
				diluicaoConfiguracaoForm.getSequencia());
		// diluicaoConfiguracao.setSequencia(diluicaoConfiguracaoForm.getSequencia());
		// diluicaoConfiguracao.setMedicamento(medicamento);
		// diluicaoConfiguracao.setViaAdministracao(viaAdministracao);
		diluicaoConfiguracao.setQuantidadeAspirada(diluicaoConfiguracaoForm.getQuantidadeAspirada());
		diluicaoConfiguracao.setQuantidadeAdicionada(diluicaoConfiguracaoForm.getQuantidadeAdicionada());
		diluicaoConfiguracao.setConcentracao(diluicaoConfiguracaoForm.getConcentracao());
		diluicaoConfiguracao.setModoPreparo(diluicaoConfiguracaoForm.getModoPreparo());
		diluicaoConfiguracao.setDiluente(diluicaoConfiguracaoForm.getDiluente());
		return diluicaoConfiguracao;
	}

	public DiluicaoConfiguracaoEntity diluicaoAtualizarFormToDiluicao(BigInteger medicamentoId, BigInteger viaAdministracaoId,
			BigInteger sequencia, DiluicaoConfiguracaoAtualizarForm diluicaoConfiguracaoAtualizarForm,
			MedicamentoRepositorio medicamentoRepository, ViaAdministracaoRepositorio viaAdministracaoRepository,
			DiluicaoConfiguracaoRepositorio diluicaoConfiguracaoRepository) {
		MedicamentoEntity medicamento = medicamentoRepository.getById(medicamentoId);
		ViaAdministracaoEntity viaAdministracao = viaAdministracaoRepository.getById(viaAdministracaoId);
		DiluicaoConfiguracaoEntityPK diluicaoConfiguracaoPK = new DiluicaoConfiguracaoEntityPK(medicamento, viaAdministracao,
				sequencia);

		
			DiluicaoConfiguracaoEntity diluicaoConfiguracao = diluicaoConfiguracaoRepository.getById(diluicaoConfiguracaoPK);
		
		// diluicaoConfiguracao.setSequencia(diluicaoConfiguracaoForm.getSequencia());
		// diluicaoConfiguracao.setMedicamento(medicamento);
		// diluicaoConfiguracao.setViaAdministracao(viaAdministracao);
		diluicaoConfiguracao.setQuantidadeAspirada(diluicaoConfiguracaoAtualizarForm.getQuantidadeAspirada());
		diluicaoConfiguracao.setQuantidadeAdicionada(diluicaoConfiguracaoAtualizarForm.getQuantidadeAdicionada());
		diluicaoConfiguracao.setConcentracao(diluicaoConfiguracaoAtualizarForm.getConcentracao());
		diluicaoConfiguracao.setModoPreparo(diluicaoConfiguracaoAtualizarForm.getModoPreparo());
		diluicaoConfiguracao.setDiluente(diluicaoConfiguracaoAtualizarForm.getDiluente());
		return diluicaoConfiguracao;
		
	}
	
}
