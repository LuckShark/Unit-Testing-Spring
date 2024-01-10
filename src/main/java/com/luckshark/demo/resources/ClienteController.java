package com.luckshark.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luckshark.demo.entities.Cliente;
import com.luckshark.demo.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable Integer id) { 
		Cliente cliente = service.buscar(id);
	
		return ResponseEntity.ok(cliente);
	}
	
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Cliente>> getAll() {
        List<Cliente> clientes = service.getAllClientes();
        return ResponseEntity.ok(clientes);
    }
}
