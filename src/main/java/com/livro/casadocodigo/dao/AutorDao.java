package com.livro.casadocodigo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livro.casadocodigo.dto.AutorDto;

public interface AutorDao extends JpaRepository<AutorDto, Long>{

}
