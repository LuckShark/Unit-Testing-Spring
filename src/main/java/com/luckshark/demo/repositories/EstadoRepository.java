package com.luckshark.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luckshark.demo.entities.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado,Integer> {

}
