package br.com.Compasso.calculadora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.Compasso.calculadora.dto.MedicamentoDto;
import br.com.Compasso.calculadora.form.AtualizaMedicamentoForm;
import br.com.Compasso.calculadora.form.MedicamentoForm;
import br.com.Compasso.calculadora.modelo.MedicamentoEntity;
import br.com.Compasso.calculadora.repositorio.MedicamentoRepositorio;

@Service
public class MedicamentoServiceImpl {
	
	
	@Autowired
	private MedicamentoRepositorio medicamentoRepositorio;

	
	public List<MedicamentoEntity> imprimi() {
		List<MedicamentoEntity> medicamento = medicamentoRepositorio.findAll();
		return medicamento;
	}

	public ResponseEntity<MedicamentoDto> detalhaId(Long id) {
		Optional<MedicamentoEntity> medicamento = medicamentoRepositorio.findById(id);
		if (medicamento.isPresent()) {
			return ResponseEntity.ok(new MedicamentoDto(medicamentoRepositorio.getById(id)));
		}

		return ResponseEntity.notFound().build();
	}

	public MedicamentoEntity inser(MedicamentoForm form) {
		Optional<MedicamentoEntity> medi = medicamentoRepositorio.findByNome(form.getNome());
		if(medi.isPresent()) {
			throw new RuntimeException("Esse nome ja existe");
		}
		else if(form.getNome().length() == 0) {
			throw new RuntimeException("Vazio");
		}
		
		MedicamentoEntity medicamento = form.converter();
		return medicamentoRepositorio.save(medicamento);

	}

	public MedicamentoEntity altera(Long id, AtualizaMedicamentoForm form) {
		Optional<MedicamentoEntity> optional = medicamentoRepositorio.findById(id);
		if(optional.isPresent()) {
			if(form.getNome().length() == 0) {
			throw new RuntimeException("Vazio");
			}
			return form.alterar(id, medicamentoRepositorio);
		}
		throw new RuntimeException("Esse id não existe");
		
	}

	public ResponseEntity<?> retirar(Long id) {
		Optional<MedicamentoEntity> medicamento = medicamentoRepositorio.findById(id);
		if (medicamento.isPresent()) {
			medicamentoRepositorio.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}

