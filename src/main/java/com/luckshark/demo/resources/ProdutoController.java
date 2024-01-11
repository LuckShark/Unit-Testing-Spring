package com.luckshark.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luckshark.demo.entities.Produto;
import com.luckshark.demo.services.ProdutoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable Integer id) { 
		Produto produto = service.buscar(id);
	
		return ResponseEntity.ok(produto);
	}
	
	@GetMapping
    public ResponseEntity<List<Produto>> getAll() {
        List<Produto> produtos = service.buscar();
        return ResponseEntity.ok(produtos);
    }
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
		service.salvar(produto);
		return ResponseEntity.ok(produto);
	}
	@PutMapping(consumes = "application/json")
	public ResponseEntity<Produto> atualizar(@RequestBody Produto produto){
		service.atualizar(produto);
		return ResponseEntity.ok(produto);
	}
}
