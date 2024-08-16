package com.challenge.cliente_persona.model;

import jakarta.persistence.Entity;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class Cliente extends Persona {
    private String numeroCuenta;
    private String tipoCuenta;
    private BigDecimal saldoInicial;
    private String estado;
}
