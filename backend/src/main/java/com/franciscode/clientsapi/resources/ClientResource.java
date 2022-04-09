package com.franciscode.clientsapi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.franciscode.clientsapi.dto.ClientsDTO;
import com.franciscode.clientsapi.services.ClientsService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	@Autowired
	private ClientsService service;
	
	@GetMapping
	public ResponseEntity<List<ClientsDTO>> findAll() {
		List<ClientsDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientsDTO> findById(@PathVariable Long id) {
		ClientsDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
}
