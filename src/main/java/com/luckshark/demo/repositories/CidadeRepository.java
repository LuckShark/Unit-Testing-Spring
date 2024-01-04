package com.luckshark.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.luckshark.demo.entities.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade,Integer> {

}
