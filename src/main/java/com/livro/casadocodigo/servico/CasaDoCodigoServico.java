package com.livro.casadocodigo.servico;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.livro.casadocodigo.cmd.CadastroAutorCmd;
import com.livro.casadocodigo.dao.AutorDao;
import com.livro.casadocodigo.dao.LivroDao;
import com.livro.casadocodigo.dto.AutorDto;
import com.livro.casadocodigo.exception.ExcecaoAplicacao;

@Service
public class CasaDoCodigoServico {
	
	@Autowired
	private AutorDao autorDao;
	@Autowired
	private LivroDao livroDao;
	@Autowired
	private Validator validator;

	public List<AutorDto> getListaAutores(){
		return autorDao.findAll();
	}
	
	public void cadastrarAutor(CadastroAutorCmd cmd) {
		Assert.notNull(cmd, "Informe os dados");
		
		Set<ConstraintViolation<CadastroAutorCmd>> violacoes = validator.validate(cmd);
		
		if(violacoes.isEmpty()) {
			AutorDto autor = new AutorDto(cmd);
			autorDao.save(autor);
		} else {
			throw new ExcecaoAplicacao(violacoes.stream().findFirst().get().getMessage());
		}	
	}
	
	public void atualizarAutor(Long id, CadastroAutorCmd cmd) {
		Assert.notNull(cmd, "Informe os dados!");
		
		Set<ConstraintViolation<CadastroAutorCmd>> violacoes = validator.validate(cmd);
		
		if(violacoes.isEmpty()) {
			Optional<AutorDto> autor = autorDao.findById(id);
			
			if(autor.isPresent()) {
				autor.get().setNome(cmd.getNome());
				autor.get().setEmail(cmd.getEmail());
				autor.get().setSenha(cmd.getSenha());
			}
		} else {
			throw new ExcecaoAplicacao("Erro ao atualizar autor!");
		}
	}
	
	public void removerAutor(Long id) {
		Optional<AutorDto> autor = autorDao.findById(id);
		
		if(autor.isPresent()) {
			autorDao.delete(autor.get());
		} else {
			throw new ExcecaoAplicacao("Erro ao remover o autor!");
		}
	}
	
}
