package com.provadeconceito.clientes.service;

import com.provadeconceito.clientes.entity.Cliente;
import com.provadeconceito.clientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;


    public Cliente salvar(Cliente cliente){
        return this.repository.save(cliente);
    }

    public Cliente findById(Integer id) {
        return this.repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deleteById(Integer id) {
        this.repository.deleteById(id);
    }

    public void update(Integer id, Cliente cliente) {
        Cliente c = this.findById(id);
        c.setCpf(cliente.getCpf());
        c.setNome(cliente.getNome());
        this.repository.save(c);
    }

    public List<Cliente> findAll() {
        return this.repository.findAll();
    }
}
