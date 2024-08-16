package com.challenge.cliente_persona.repository;

import com.challenge.cliente_persona.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
