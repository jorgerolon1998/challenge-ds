package controller;

import model.Movimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.MovimientoService;

import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    @GetMapping
    public List<Movimiento> findAll() {
        return movimientoService.findAll();
    }

    @PostMapping
    public Movimiento save(@RequestBody Movimiento movimiento) {
        return movimientoService.save(movimiento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        movimientoService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}