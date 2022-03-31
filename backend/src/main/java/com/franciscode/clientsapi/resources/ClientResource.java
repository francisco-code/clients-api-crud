package com.franciscode.clientsapi.resources;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.franciscode.clientsapi.entities.Client;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll() {
		List<Client> list = new ArrayList<>();
		list.add(new Client(1L, "Lindalva Moreira", "123.456.113-80", 3000.0, Instant.parse("1955-12-06T10:30:00Z"), 4));
		list.add(new Client(2L, "José Aldenísio", "123.456.113-80", 3000.0, Instant.parse("1953-05-31T10:30:00Z"), 4));
		
		return ResponseEntity.ok().body(list);
	}
	
}
