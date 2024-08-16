package service;

import exception.ResourceNotFoundException;
import exception.SaldoInsuficienteException;
import model.Cuenta;
import model.Movimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CuentaRepository;
import repository.MovimientoRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    public List<Movimiento> findAll() {
        return movimientoRepository.findAll();
    }

    public Movimiento save(Movimiento movimiento) {
        Cuenta cuenta = cuentaRepository.findById(movimiento.getCuenta().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Cuenta no encontrada"));

        BigDecimal nuevoSaldo = cuenta.getSaldoInicial().add(movimiento.getValor());

        if (nuevoSaldo.compareTo(BigDecimal.ZERO) < 0) {
            throw new SaldoInsuficienteException("Saldo no Disponible");
        }

        cuenta.setSaldoInicial(nuevoSaldo);
        cuentaRepository.save(cuenta);

        movimiento.setSaldo(nuevoSaldo);
        return movimientoRepository.save(movimiento);
    }

    public void deleteById(Long id) {
        movimientoRepository.deleteById(id);
    }
}
