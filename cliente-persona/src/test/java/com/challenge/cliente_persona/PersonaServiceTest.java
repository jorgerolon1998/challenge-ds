package com.challenge.cliente_persona;

import com.challenge.cliente_persona.model.Persona;
import com.challenge.cliente_persona.repository.PersonaRepository;
import com.challenge.cliente_persona.service.PersonaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonaServiceTest {

    @Mock
    private PersonaRepository personaRepository;

    @InjectMocks
    private PersonaService personaService;

    @Test
    public void testFindAll() {
        Persona persona1 = new Persona();
        persona1.setNombre("Juan");
        Persona persona2 = new Persona();
        persona2.setNombre("Maria");

        when(personaRepository.findAll()).thenReturn(Arrays.asList(persona1, persona2));

        List<Persona> personas = personaService.findAll();
        assertEquals(2, personas.size());
        verify(personaRepository, times(1)).findAll();
    }

    @Test
    public void testSave() {
        Persona persona = new Persona();
        persona.setNombre("Pedro");

        when(personaRepository.save(persona)).thenReturn(persona);

        Persona savedPersona = personaService.save(persona);
        assertEquals("Pedro", savedPersona.getNombre());
        verify(personaRepository, times(1)).save(persona);
    }
}