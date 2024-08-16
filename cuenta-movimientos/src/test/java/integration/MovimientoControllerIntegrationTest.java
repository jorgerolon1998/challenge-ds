package integration;

import model.Movimiento;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import repository.MovimientoRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class MovimientoControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Test
    public void testGetAllMovimientos() {
        ResponseEntity<Movimiento[]> response = restTemplate.getForEntity("http://localhost:" + port + "/movimientos", Movimiento[].class);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
    }
}
