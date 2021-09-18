package br.com.Compasso.calculadora.service;


import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.Compasso.calculadora.form.AtualizaViaAdmForm;
import br.com.Compasso.calculadora.form.ViaAdministracaoForm;
import br.com.Compasso.calculadora.modelo.ViaAdministracaoEntity;
import br.com.Compasso.calculadora.repositorio.ViaAdministracaoRepositorio;

@Service
public class ViaAdministracaoServiceImpl {

	@Autowired
	private ViaAdministracaoRepositorio viaAdministracaoRepositorio;
	
	public List<ViaAdministracaoEntity> listar() {
		List<ViaAdministracaoEntity> viaAdm = viaAdministracaoRepositorio.findAll();// Consulta todos os registros
		return viaAdm;
	}
	
	// POST insere no Banco de dados
		public ViaAdministracaoEntity inserir(ViaAdministracaoForm form) {
			Optional<ViaAdministracaoEntity> via = viaAdministracaoRepositorio.findByNome(form.getNome());
			if(via.isPresent()) { // verifica se esta presente
				throw new RuntimeException("Esse nome ja existe"); // gera RuntimeException
			}
			else if(form.getNome().length() == 0) { // examina se o campo nome estiver vazio
				throw new RuntimeException("Vazio");
			}
			
			ViaAdministracaoEntity viaAdm = form.converte();
			return viaAdministracaoRepositorio.save(viaAdm); // Salvar no Banco de Dados

		}
		
		//PUT atualiza o elemento
		public ViaAdministracaoEntity altera(BigInteger id, AtualizaViaAdmForm form) {
			Optional<ViaAdministracaoEntity> optional = viaAdministracaoRepositorio.findById(id);
			if(optional.isPresent()) {
				
				if(form.getNome().length() == 0) {
				throw new RuntimeException("Vazio");
				}
				return form.altera(id, viaAdministracaoRepositorio); //Atualiza o nome
			}
			throw new RuntimeException("Esse id não existe");
		}
		
		
		// DELETE remove o elemento do Banco de dados
		public ResponseEntity<?> retirar(BigInteger id) {
			Optional<ViaAdministracaoEntity> viaAdm= viaAdministracaoRepositorio.findById(id);
			if (viaAdm.isPresent()) {
				viaAdministracaoRepositorio.deleteById(id); // remove pelo id
				return ResponseEntity.ok().build();
			}
			return ResponseEntity.notFound().build();
		}

	
}
