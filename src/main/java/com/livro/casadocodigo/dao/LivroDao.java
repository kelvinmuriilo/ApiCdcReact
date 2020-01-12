package com.livro.casadocodigo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livro.casadocodigo.dto.LivroDto;

public interface LivroDao extends JpaRepository<LivroDto, Long>{

}
