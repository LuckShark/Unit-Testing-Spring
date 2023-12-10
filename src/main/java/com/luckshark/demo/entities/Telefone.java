package com.luckshark.demo.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Telefone implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String numero;

    public Telefone() {
        // Construtor padrão sem argumentos
    }

    public Telefone(String numero) {
        this.numero = numero;
    }

    // Getters e Setters

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Telefone telefone = (Telefone) obj;
        return Objects.equals(numero, telefone.numero);
    }
}
