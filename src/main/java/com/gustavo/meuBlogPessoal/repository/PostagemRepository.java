package com.gustavo.meuBlogPessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.gustavo.meuBlogPessoal.model.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long>{

	public List <Postagem> findAllByTituloContainingIgnoreCase (@Param("titulo") String titulo);
}
