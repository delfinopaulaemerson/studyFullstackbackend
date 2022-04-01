package com.provadeconceito.clientes.repository;

import com.provadeconceito.clientes.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicoRepository extends JpaRepository<Servico,Integer> {

    @Query("select s from Servico s , Cliente c where s.cliente.id = c.id  and s.cliente.nome like %:nome% or MONTH(s.data)=:mes ")
    List<Servico> findByNomeAndMes(@Param("nome") String nome,@Param("mes") Integer mes);
}
