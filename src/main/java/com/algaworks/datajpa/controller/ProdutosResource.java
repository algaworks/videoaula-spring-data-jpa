package com.algaworks.datajpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.datajpa.model.Produto;
import com.algaworks.datajpa.repository.Produtos;

@RestController
@RequestMapping("/produtos")
public class ProdutosResource {
	
	@Autowired
	private Produtos produtos;
	
	@GetMapping("/relatorio")
	public List<Produto> relatorio(Produto produto) {
		return produtos.relatorioMensal(produto);
	}
	
	@GetMapping("/namedQuery")
	public List<Produto> namedQuery() {
		return produtos.namedQuery();
	}
	
	@GetMapping("/findByNomeStartingWithOrderByNomeDesc")
	public List<Produto> findByNomeStartingWithOrderByNomeDesc(@RequestParam String nome) {
		return produtos.findByNomeStartingWithOrderByNomeDesc(nome);
	}
	
	@DeleteMapping("/deletar")
	public void deletar(@RequestParam Long id) {
		produtos.delete(id);;
	}
	
	@PostMapping("/salvar")
	public Produto salvar(@RequestBody Produto produto) {
		return produtos.save(produto);
	}
	
	@GetMapping("/paginacao")
	public Page<Produto> paginacao(@RequestParam int page, @RequestParam int size) {
		return produtos.findAll(new PageRequest(page, size));
	}
	
	@GetMapping("/ordenacao")
	public List<Produto> ordenacao() {
		return produtos.findAll(new Sort(Direction.ASC, "nome"));
	}
	
	@GetMapping("/todos")
	public List<Produto> todos() {
		return produtos.findAll();
	}
	
	@GetMapping("/um")
	public Produto um(@RequestParam Long id) {
		return produtos.findOne(id);
	}
}
