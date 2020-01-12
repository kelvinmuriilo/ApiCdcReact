package com.livro.casadocodigo.cmd;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CadastroAutorCmd {
	@NotBlank(message = "Informe o nome")
	private String nome;
	@NotBlank(message = "Informe o e-mail")
	private String email;
	@NotBlank(message = "Informe a senha")
	private String senha;
	
	public CadastroAutorCmd() {
		//construtor padrão para o jackson
	}
	
	public CadastroAutorCmd(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
