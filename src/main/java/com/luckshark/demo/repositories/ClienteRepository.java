package com.luckshark.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luckshark.demo.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

}
