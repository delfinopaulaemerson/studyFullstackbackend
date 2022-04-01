package com.provadeconceito.clientes.controller;

import com.provadeconceito.clientes.dto.ServicoDto;
import com.provadeconceito.clientes.entity.Servico;
import com.provadeconceito.clientes.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servico")
public class ServicoController {

    @Autowired
    private ServicoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Servico salvar(@RequestBody ServicoDto servicoDto){
     Servico servico = this.service.dtoToServico(servicoDto);
        return this.service.salvar(servico);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Servico> findByNomeAndMes(@RequestParam(value = "nome", required = false,name = "") String nome,
                                          @RequestParam(value = "mes", required = false) Integer mes ){
        return this.service.findByNomeAndMes(nome,mes);
    }

}
