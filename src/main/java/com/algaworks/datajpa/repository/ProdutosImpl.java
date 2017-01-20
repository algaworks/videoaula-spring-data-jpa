package com.algaworks.datajpa.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.algaworks.datajpa.model.Produto;

public class ProdutosImpl implements ProdutosRelatorio {
	
	@Autowired
	private EntityManager manager;

	@Override
	public List<Produto> relatorioMensal(Produto produto) {
		return manager
				.createQuery("from Produto where nome = :nome", Produto.class)
				.setParameter("nome", produto.getNome())
				.getResultList();
	}

}
