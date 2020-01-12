package com.livro.casadocodigo.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.livro.casadocodigo.cmd.CadastroAutorCmd;

@Entity
public class AutorDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String email;
	@JsonIgnore
	private String senha;
	@OneToMany(mappedBy = "autor")
	private List<LivroDto> livros = new ArrayList<>();
	
	//Construtor vazio para o JPA
	public AutorDto(){}
	
	public AutorDto(CadastroAutorCmd cmd){
		this.nome = cmd.getNome();
		this.email = cmd.getEmail();
		this.senha = cmd.getSenha();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<LivroDto> getLivros() {
		return livros;
	}

	public void setLivros(ArrayList<LivroDto> livros) {
		this.livros = livros;
	}

	public long getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((livros == null) ? 0 : livros.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutorDto other = (AutorDto) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (livros == null) {
			if (other.livros != null)
				return false;
		} else if (!livros.equals(other.livros))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}
}
