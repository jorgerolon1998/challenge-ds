package com.challenge.cuenta_movimientos;

import model.Cuenta;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import repository.CuentaRepository;
import service.CuentaService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CuentaServiceTest {

    @Mock
    private CuentaRepository cuentaRepository;

    @InjectMocks
    private CuentaService cuentaService;

    public CuentaServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        Cuenta cuenta1 = new Cuenta();
        cuenta1.setNumeroCuenta("12345");
        Cuenta cuenta2 = new Cuenta();
        cuenta2.setNumeroCuenta("67890");

        when(cuentaRepository.findAll()).thenReturn(Arrays.asList(cuenta1, cuenta2));

        List<Cuenta> cuentas = cuentaService.findAll();
        assertEquals(2, cuentas.size());
        verify(cuentaRepository, times(1)).findAll();
    }

    @Test
    public void testSave() {
        Cuenta cuenta = new Cuenta();
        cuenta.setNumeroCuenta("12345");

        when(cuentaRepository.save(cuenta)).thenReturn(cuenta);

        Cuenta savedCuenta = cuentaService.save(cuenta);
        assertEquals("12345", savedCuenta.getNumeroCuenta());
        verify(cuentaRepository, times(1)).save(cuenta);
    }
}
