package com.provadeconceito.clientes.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 255)
    private  String descricao;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column
    private BigDecimal valor;


    @Column(name = "data_servico", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    @PrePersist
    public void prePersist(){
        setData(LocalDate.now());
    }
}
