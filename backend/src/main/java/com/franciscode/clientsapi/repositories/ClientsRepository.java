package com.franciscode.clientsapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.franciscode.clientsapi.entities.Clients;

@Repository
public interface ClientsRepository extends JpaRepository<Clients, Long> {

}
