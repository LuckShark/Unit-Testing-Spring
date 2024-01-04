package com.luckshark.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luckshark.demo.entities.Estado;
import com.luckshark.demo.repositories.EstadoRepository;
import com.luckshark.demo.services.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repository;
	
	public Estado buscar(Integer id) {
		Optional<Estado> estado = repository.findById(id);
		return estado.orElseThrow(() -> new ObjectNotFoundException(
				"Lugar nao encontrado! Id: " + id ));
	}
}
