package com.luckshark.demo.services;

import java.util.List;
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
	public List<Produto> buscar() {
        return repository.findAll();
    }
	public Produto salvar(Produto produto) {
		return repository.save(produto);
	}
	public Produto atualizar(Produto produto) {
		Produto produtoatualizar = buscar(produto.getId());
		produtoatualizar.setNome(produto.getNome());
		produtoatualizar.setPreco(produto.getPreco());
		return repository.save(produtoatualizar); //na real é igual ao salvar (post) 
		
	}
}
