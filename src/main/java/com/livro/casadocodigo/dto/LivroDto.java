package com.livro.casadocodigo.dto;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LivroDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String titulo;
	private BigDecimal preco;
	@ManyToOne
	private AutorDto autor;
	
	//Construtor vazio para o JPA
	public LivroDto(){}
	
	public LivroDto(String titulo, BigDecimal preco, AutorDto autor) {
		this.titulo = titulo;
		this.autor = autor;
		this.preco = preco;
	}

	public long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public AutorDto getAutor() {
		return autor;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		LivroDto other = (LivroDto) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (id != other.id)
			return false;
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

}
