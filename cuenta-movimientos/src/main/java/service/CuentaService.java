package service;

import model.Cuenta;
import model.Movimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CuentaRepository;
import repository.MovimientoRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private MovimientoRepository movimientoRepository;

    public List<Cuenta> findAll() {
        return cuentaRepository.findAll();
    }

    public Cuenta save(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public void deleteById(Long id) {
        cuentaRepository.deleteById(id);
    }

    public List<Movimiento> getReporteEstadoCuenta(Long clienteId, LocalDate fechaInicio, LocalDate fechaFin) {
        List<Cuenta> cuentas = cuentaRepository.findByClienteId(clienteId);

        // Filtrar los movimientos para las cuentas del cliente en el rango de fechas
        return movimientoRepository.findByCuentaInAndFechaBetween(cuentas, fechaInicio, fechaFin);
    }
}
