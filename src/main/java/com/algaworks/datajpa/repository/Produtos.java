package com.algaworks.datajpa.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.algaworks.datajpa.model.Produto;

public interface Produtos extends JpaRepository<Produto, Long>, ProdutosRelatorio {
	
	Produto findByNome(String nome);
	
	List<Produto> findByNomeStartingWith(String nome);
	
	List<Produto> findByNomeStartingWithOrderByNomeDesc(String nome);
	
	List<Produto> findAllByNomeAndDescricaoStartingWith(String nome, String descricao);
	
	List<Produto> findAllByCadastroAfter(Date cadastro);
	
	List<Produto> namedQuery();
	
	@Query("from Produto")
	List<Produto> query();

}
