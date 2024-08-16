
# Cliente-Persona 

## Descripción

Este microservicio es responsable de gestionar las entidades `Persona` y `Cliente` en la aplicación. Utiliza Java con Spring Boot y JPA para manejar la persistencia de datos, y RabbitMQ para la comunicación asincrónica con otros microservicios. El microservicio está desplegado en Docker y está preparado para ser ejecutado en un entorno de contenedores.

## Requisitos

- **Java 11** o superior
- **Maven**
- **Docker** y **Docker Compose**
- **Postman v9.13.2** o superior para pruebas de endpoints

## Instalación y Ejecución

### 1. Compilación del Proyecto

Para compilar el proyecto, asegúrate de tener Maven o Gradle configurado. Ejecuta el siguiente comando en la raíz del proyecto:

**Con Maven:**
```bash
mvn clean install
```

**Con Gradle:**
```bash
gradle clean build
```

### 2. Ejecución en Local

Para ejecutar el microservicio en tu máquina local:

**Con Maven:**
```bash
mvn spring-boot:run
```

El servicio estará disponible en `http://localhost:8080`.

### 3. Ejecución en Docker

Para ejecutar el microservicio en Docker:

1. Asegúrate de que Docker y Docker Compose estén instalados.
2. Navega hasta el directorio raíz del proyecto.
3. Ejecuta el siguiente comando:

```bash
docker-compose up --build
```

Esto levantará el contenedor del microservicio junto con RabbitMQ y PostgreSQL.

## Endpoints de la API

### Persona

- **GET** `/personas`
  - Descripción: Retorna todas las personas registradas.
  - Ejemplo de Respuesta:
    ```json
    [
        {
            "id": 1,
            "nombre": "Juan Pérez",
            "genero": "Masculino",
            "edad": 30,
            "identificacion": "12345678",
            "direccion": "Av. Siempre Viva 123",
            "telefono": "123-456-789"
        }
    ]
    ```

- **POST** `/personas`
  - Descripción: Crea una nueva persona.
  - Cuerpo de la Solicitud:
    ```json
    {
        "nombre": "Juan Pérez",
        "genero": "Masculino",
        "edad": 30,
        "identificacion": "12345678",
        "direccion": "Av. Siempre Viva 123",
        "telefono": "123-456-789"
    }
    ```
  - Ejemplo de Respuesta:
    ```json
    {
        "id": 1,
        "nombre": "Juan Pérez",
        "genero": "Masculino",
        "edad": 30,
        "identificacion": "12345678",
        "direccion": "Av. Siempre Viva 123",
        "telefono": "123-456-789"
    }
    ```

### Cliente

- **GET** `/clientes`
  - Descripción: Retorna todos los clientes registrados.
  - Ejemplo de Respuesta:
    ```json
    [
        {
            "id": 1,
            "nombre": "Juan Pérez",
            "numeroCuenta": "0011223344",
            "tipoCuenta": "Corriente",
            "saldoInicial": 1000.00,
            "estado": "Activo"
        }
    ]
    ```

- **POST** `/clientes`
  - Descripción: Crea un nuevo cliente.
  - Cuerpo de la Solicitud:
    ```json
    {
        "nombre": "Juan Pérez",
        "numeroCuenta": "0011223344",
        "tipoCuenta": "Corriente",
        "saldoInicial": 1000.00,
        "estado": "Activo"
    }
    ```
  - Ejemplo de Respuesta:
    ```json
    {
        "id": 1,
        "nombre": "Juan Pérez",
        "numeroCuenta": "0011223344",
        "tipoCuenta": "Corriente",
        "saldoInicial": 1000.00,
        "estado": "Activo"
    }
    ```

- **PUT** `/clientes/{id}`
  - Descripción: Actualiza un cliente existente.
  - Cuerpo de la Solicitud:
    ```json
    {
        "nombre": "Juan Pérez",
        "numeroCuenta": "0011223344",
        "tipoCuenta": "Corriente",
        "saldoInicial": 1200.00,
        "estado": "Activo"
    }
    ```

- **DELETE** `/clientes/{id}`
  - Descripción: Elimina un cliente existente.

## Pruebas

### Pruebas Unitarias

Para ejecutar las pruebas unitarias:

**Con Maven:**
```bash
mvn test
```

**Con Gradle:**
```bash
gradle test
```

### Pruebas de Integración

Para ejecutar las pruebas de integración, se utiliza una base de datos en memoria (H2). Estas pruebas están incluidas en el conjunto de pruebas unitarias.

## Archivo Postman

Para facilitar la prueba de los endpoints, se incluye un archivo `.json` de Postman con todas las solicitudes configuradas. Puedes importarlo en Postman para realizar las pruebas de manera sencilla.

## Despliegue en Producción

1. Configura las variables de entorno necesarias para la base de datos y RabbitMQ.
2. Utiliza Docker Compose para desplegar el servicio junto con sus dependencias.

```bash
docker-compose up -d
```


