package com.luckshark.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luckshark.demo.entities.Cliente;
import com.luckshark.demo.repositories.ClienteRepository;
import com.luckshark.demo.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> cliente = repository.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoundException(
				"Cliente nao encontrado! Id: " + id + " Tipo: " + Cliente.class.getName()));
	}
}
