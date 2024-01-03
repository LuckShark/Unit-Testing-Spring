package com.luckshark.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luckshark.demo.entities.Categoria;
import com.luckshark.demo.repositories.CategoriaRepository;
import com.luckshark.demo.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> categoria = repository.findById(id);
		return categoria.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado! Id: " + id + " Tipo: " + Categoria.class.getName()));
	}
}
