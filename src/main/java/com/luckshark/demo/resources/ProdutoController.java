package com.luckshark.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luckshark.demo.entities.Categoria;
import com.luckshark.demo.entities.Produto;
import com.luckshark.demo.services.CategoriaService;
import com.luckshark.demo.services.ProdutoService;

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
}
