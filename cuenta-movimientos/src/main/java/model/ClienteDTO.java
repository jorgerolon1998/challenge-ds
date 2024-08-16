package model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClienteDTO implements Serializable {
    private Long id;
    private String nombre;
    private String numeroCuenta;
    private String tipoCuenta;
    private String estado;
}
