package com.challenge.cliente_persona.api;

import com.challenge.cliente_persona.model.Persona;
import com.challenge.cliente_persona.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public List<Persona> findAll() {
        return personaService.findAll();
    }

    @PostMapping
    public Persona save(@RequestBody Persona persona) {
        return personaService.save(persona);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        personaService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
