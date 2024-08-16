package com.challenge.cliente_persona.repository;

import com.challenge.cliente_persona.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
