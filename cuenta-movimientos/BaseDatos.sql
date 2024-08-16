CREATE TABLE persona (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100),
    genero VARCHAR(10),
    edad INT,
    identificacion VARCHAR(50),
    direccion VARCHAR(200),
    telefono VARCHAR(15)
);

CREATE TABLE cliente (
    id SERIAL PRIMARY KEY,
    numero_cuenta VARCHAR(20) UNIQUE NOT NULL,
    tipo_cuenta VARCHAR(20),
    saldo_inicial DECIMAL(19, 2),
    estado VARCHAR(10),
    persona_id INT REFERENCES persona(id)
);

CREATE TABLE cuenta (
    id SERIAL PRIMARY KEY,
    numero_cuenta VARCHAR(20) UNIQUE NOT NULL,
    tipo_cuenta VARCHAR(20),
    saldo_inicial DECIMAL(19, 2),
    estado VARCHAR(10),
    cliente_id INT REFERENCES cliente(id)
);

CREATE TABLE movimiento (
    id SERIAL PRIMARY KEY,
    fecha DATE NOT NULL,
    tipo_movimiento VARCHAR(20),
    valor DECIMAL(19, 2),
    saldo DECIMAL(19, 2),
    cuenta_id INT REFERENCES cuenta(id)
);
