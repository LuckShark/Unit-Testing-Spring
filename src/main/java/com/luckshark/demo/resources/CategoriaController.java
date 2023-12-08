package com.luckshark.demo.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luckshark.demo.entities.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {
	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> list() {
		Categoria cat1 = new Categoria(1,"Informática");
		Categoria cat2 = new Categoria(2,"Escritória");

		List<Categoria> categorias = new ArrayList<>();
		categorias.add(cat1);
		categorias.add(cat2);
		
		return categorias;
	}
}
