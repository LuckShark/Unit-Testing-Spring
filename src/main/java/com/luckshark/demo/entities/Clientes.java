package com.luckshark.demo.entities;

import java.io.Serializable;
import java.util.Objects;

import com.luckshark.demo.entities.enums.TipoCliente;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity //é uma entidade que será mapeada para uma table no banco
public class Clientes implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id //esse atributo será chave primária da entidade
	@GeneratedValue(strategy=GenerationType.IDENTITY) //associada ao autoinccremento
	private Integer id; //essa é a chave primária  da entidade
	private String nome;
	private String email;
	private String cpfOuCnpj;
	private TipoCliente tipo; //é o tipo de cliente baseado em uma enumeração chamada Tipo cliente
	
	public Clientes() {
		//faço um construtor padrão sem argumentos
	}
	
	public Clientes(Integer id, String nome, String email, String cpfOuCnpj, TipoCliente tipo) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipo = tipo;
	} //esse segundo construtor aceita todos os atributos da classe para facilitar a criação de instancias da classe

	//abaixo os Getters e Setters
	//Para obter e definir os valores dos atributos da classe
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public TipoCliente getTipo() {
		return tipo;
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clientes other = (Clientes) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
