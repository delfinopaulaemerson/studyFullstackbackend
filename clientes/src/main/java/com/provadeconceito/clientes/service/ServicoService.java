package com.provadeconceito.clientes.service;

import com.provadeconceito.clientes.dto.ServicoDto;
import com.provadeconceito.clientes.entity.Cliente;
import com.provadeconceito.clientes.entity.Servico;
import com.provadeconceito.clientes.repository.ClienteRepository;
import com.provadeconceito.clientes.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ServicoService {
    @Autowired
    private ServicoRepository servicoRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    public Servico dtoToServico(ServicoDto servicoDto) {
        Cliente c = this.clienteRepository.findById(servicoDto.getIdCliente()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        LocalDate data = LocalDate.parse(servicoDto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Servico servico = Servico.builder()
                .cliente(c)
                .data(data)
                .descricao(servicoDto.getDescricao())
                .valor(new BigDecimal(servicoDto.getPreco()))
                .build();
        return servico;
    }

    public Servico salvar(Servico servico) {
        return this.servicoRepository.save(servico);
    }

    public List<Servico> findByNomeAndMes(String nome, Integer mes) {
        List<Servico> servicos = this.servicoRepository.findByNomeAndMes(nome,mes);
        return servicos;
    }
}
