package com.franciscode.clientsapi.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.franciscode.clientsapi.dto.ClientsDTO;
import com.franciscode.clientsapi.entities.Clients;
import com.franciscode.clientsapi.repositories.ClientsRepository;
import com.franciscode.clientsapi.services.exceptions.DataBaseException;
import com.franciscode.clientsapi.services.exceptions.ResourceNotFoundException;

@Service
public class ClientsService {
	
	@Autowired
	private ClientsRepository repository;

	@Transactional(readOnly = true)
	public Page<ClientsDTO> findAllPaged(PageRequest pageRequest) {
		Page<Clients> list = repository.findAll(pageRequest);
		return list.map(x -> new ClientsDTO(x));
	}

	@Transactional(readOnly = true)
	public ClientsDTO findById(Long id) {
		Optional<Clients> obj = repository.findById(id);
		Clients entity = obj.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
		return new ClientsDTO(entity);
	}

	@Transactional
	public ClientsDTO insert(ClientsDTO dto) {
		Clients entity = new Clients();
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setChildren(dto.getChildren());
		entity.setBirthDate(dto.getBirthDate());
		entity = repository.save(entity);
		
		return new ClientsDTO(entity);
	}

	@Transactional
	public ClientsDTO update(Long id, ClientsDTO dto) {
		try {
			Clients entity = repository.getById(id);
			entity.setName(dto.getName());
			entity.setCpf(dto.getCpf());
			entity.setIncome(dto.getIncome());
			entity.setChildren(dto.getChildren());
			entity.setBirthDate(dto.getBirthDate());
			entity = repository.save(entity);
			return new ClientsDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id não encontrado" + id);
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id não encontrado" + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Violação de integridade");
		}
		
	}
}
