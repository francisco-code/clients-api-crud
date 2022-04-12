package com.franciscode.clientsapi.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.franciscode.clientsapi.dto.ClientsDTO;
import com.franciscode.clientsapi.entities.Clients;
import com.franciscode.clientsapi.repositories.ClientsRepository;
import com.franciscode.clientsapi.services.exceptions.EntityNotFoundException;

@Service
public class ClientsService {
	
	@Autowired
	private ClientsRepository repository;

	@Transactional(readOnly = true)
	public List<ClientsDTO> findAll() {
		List<Clients> list = repository.findAll();
		return list.stream().map(x -> new ClientsDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public ClientsDTO findById(Long id) {
		Optional<Clients> obj = repository.findById(id);
		Clients entity = obj.orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
		return new ClientsDTO(entity);
	}
}
