package com.luckshark.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luckshark.demo.entities.Produto;
import com.luckshark.demo.repositories.ProdutoRepository;
import com.luckshark.demo.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	public Produto buscar(Integer id) {
		Optional<Produto> produto = repository.findById(id);
		return produto.orElseThrow(() -> new ObjectNotFoundException(
				"Produto nao encontrado! Id: " + id + " Tipo: " + Produto.class.getName()));
	}
}
