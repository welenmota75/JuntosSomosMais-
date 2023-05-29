package br.ifsp.projetolp2.controller;

import br.ifsp.projetolp2.cliente.Cliente;
import br.ifsp.projetolp2.cliente.ClienteRepository;
import br.ifsp.projetolp2.cliente.ClienteRequestDTO;
import br.ifsp.projetolp2.cliente.ClienteResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;
    @CrossOrigin (origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveCliente(@RequestBody ClienteRequestDTO data){
        Cliente clienteData = new Cliente(data);
        repository.save(clienteData);
        return;
    }

    @GetMapping
    public List<ClienteResponseDTO> getAll(){

        List<ClienteResponseDTO> clienteList = repository.findAll().stream().map(ClienteResponseDTO::new).toList();
        return clienteList;
    }


    }

