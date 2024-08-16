package com.challenge.cliente_persona.service;

import com.challenge.cliente_persona.async.RabbitMQConfig;
import com.challenge.cliente_persona.model.Cliente;
import com.challenge.cliente_persona.model.ClienteDTO;
import com.challenge.cliente_persona.repository.ClienteRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RabbitMQConfig rabbitMQConfig;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente save(Cliente cliente) {
        Cliente savedCliente = clienteRepository.save(cliente);

        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(savedCliente.getId());
        clienteDTO.setNombre(savedCliente.getNombre());
        clienteDTO.setNumeroCuenta(savedCliente.getNumeroCuenta());
        clienteDTO.setTipoCuenta(savedCliente.getTipoCuenta());
        clienteDTO.setEstado(savedCliente.getEstado());

        rabbitTemplate.convertAndSend(rabbitMQConfig.EXCHANGE_NAME, rabbitMQConfig.ROUTING_KEY, clienteDTO);
        return savedCliente;
    }


    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }
}
