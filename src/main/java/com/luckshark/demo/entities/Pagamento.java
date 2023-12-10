package com.luckshark.demo.entities;

import java.io.Serializable;
import java.util.Objects;

import com.luckshark.demo.entities.enums.EstadoPagamento;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pagamento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private EstadoPagamento estado;

    public Pagamento() {
       
    }

    public Pagamento(Integer id, EstadoPagamento estado) {
        this.id = id;
        this.estado = estado;
    }

    // Getters e Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EstadoPagamento getEstado() {
        return estado;
    }

    public void setEstado(EstadoPagamento estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Pagamento pagamento = (Pagamento) obj;
        return Objects.equals(id, pagamento.id);
    }
}
