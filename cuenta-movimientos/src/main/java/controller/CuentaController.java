package controller;

import model.Cuenta;
import model.Movimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.CuentaService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @GetMapping
    public List<Cuenta> findAll() {
        return cuentaService.findAll();
    }

    @PostMapping
    public Cuenta save(@RequestBody Cuenta cuenta) {
        return cuentaService.save(cuenta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        cuentaService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/reportes")
    public ResponseEntity<List<Movimiento>> getReporteEstadoCuenta(
            @RequestParam("cliente") Long clienteId,
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {

        List<Movimiento> movimientos = cuentaService.getReporteEstadoCuenta(clienteId, fechaInicio, fechaFin);
        return ResponseEntity.ok(movimientos);
    }
}
