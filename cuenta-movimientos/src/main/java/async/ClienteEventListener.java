package async;

import model.ClienteDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ClienteEventListener {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void handleClienteCreatedEvent(ClienteDTO cliente) {
        System.out.println("Nuevo cliente recibido: " + cliente.getNombre());
    }
}
