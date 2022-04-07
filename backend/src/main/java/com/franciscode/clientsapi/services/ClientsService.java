package com.franciscode.clientsapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franciscode.clientsapi.entities.Clients;
import com.franciscode.clientsapi.repositories.ClientsRepository;

@Service
public class ClientsService {
	
	@Autowired
	private ClientsRepository repository;

	public List<Clients> findAll() {
		
		return repository.findAll();
	}
}
