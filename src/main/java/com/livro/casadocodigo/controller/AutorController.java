package com.livro.casadocodigo.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.livro.casadocodigo.cmd.CadastroAutorCmd;
import com.livro.casadocodigo.dto.AutorDto;
import com.livro.casadocodigo.servico.CasaDoCodigoServico;

@RestController
@RequestMapping("/autores")
@CrossOrigin(origins = "http://localhost:3000")
public class AutorController {
	
	@Autowired
	private CasaDoCodigoServico cdcServico;
	
	@GetMapping
	public List<AutorDto> getListaAutores(){
		return cdcServico.getListaAutores();
	}
	
	@PostMapping()
	@Transactional
	public ResponseEntity<String> cadastrarAutor(@RequestBody CadastroAutorCmd cmd){
		cdcServico.cadastrarAutor(cmd);
		return ResponseEntity.ok("Cadastro realizado com sucesso!");
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<String> atualizarAutor(@PathVariable Long id, @RequestBody CadastroAutorCmd cmd){
		cdcServico.atualizarAutor(id, cmd);
		return ResponseEntity.ok("Autor atualizado com sucesso!");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removerAutor(@PathVariable Long id){
		cdcServico.removerAutor(id);
		return ResponseEntity.ok("Autor excluído com sucesso!");
	}
}
