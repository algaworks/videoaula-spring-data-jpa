package com.algaworks.datajpa.repository;

import java.util.List;

import com.algaworks.datajpa.model.Produto;

public interface ProdutosRelatorio {
	
	List<Produto> relatorioMensal(Produto produto);

}
