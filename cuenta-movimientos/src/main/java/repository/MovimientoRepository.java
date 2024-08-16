package repository;

import model.Cuenta;
import model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    List<Movimiento> findByCuentaInAndFechaBetween(List<Cuenta> cuentas, LocalDate fechaInicio, LocalDate fechaFin);
}
