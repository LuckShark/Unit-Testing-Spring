package com.luckshark.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luckshark.demo.entities.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Integer> {

}
