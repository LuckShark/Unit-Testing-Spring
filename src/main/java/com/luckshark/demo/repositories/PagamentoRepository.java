package com.luckshark.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luckshark.demo.entities.Pagamento;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento,Integer> {

}
