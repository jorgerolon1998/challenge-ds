package com.challenge.cuenta_movimientos;

import model.Movimiento;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import repository.MovimientoRepository;
import service.MovimientoService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class MovimientoServiceTest {

    @Mock
    private MovimientoRepository movimientoRepository;

    @InjectMocks
    private MovimientoService movimientoService;

    public MovimientoServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        Movimiento movimiento1 = new Movimiento();
        movimiento1.setValor(new BigDecimal("100.00"));
        Movimiento movimiento2 = new Movimiento();
        movimiento2.setValor(new BigDecimal("200.00"));

        when(movimientoRepository.findAll()).thenReturn(Arrays.asList(movimiento1, movimiento2));

        List<Movimiento> movimientos = movimientoService.findAll();
        assertEquals(2, movimientos.size());
        verify(movimientoRepository, times(1)).findAll();
    }

    @Test
    public void testSave() {
        Movimiento movimiento = new Movimiento();
        movimiento.setValor(new BigDecimal("100.00"));

        when(movimientoRepository.save(movimiento)).thenReturn(movimiento);

        Movimiento savedMovimiento = movimientoService.save(movimiento);
        assertEquals(new BigDecimal("100.00"), savedMovimiento.getValor());
        verify(movimientoRepository, times(1)).save(movimiento);
    }
}
