package com.luckshark.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.luckshark.demo.entities.enums.TipoCliente;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity //é uma entidade que será mapeada para uma table no banco
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id //esse atributo será chave primária da entidade
	@GeneratedValue(strategy=GenerationType.IDENTITY) //associada ao autoinccremento
	private Integer id; //essa é a chave primária  da entidade
	private String nome;
	private String email;
	private String cpfOuCnpj;
	private Integer tipo; //é o tipo de cliente baseado em uma enumeração chamada Tipo cliente / mudou para inteiro
	@JsonManagedReference
	@OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos = new ArrayList<>();
	@CollectionTable(name = "telefone")
	@ElementCollection
	private Set<String> telefones = new HashSet<String>(); //uma lista de números que não se repete, para isso eu uso o Set (hashSet é uma maneira de varrer)
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos = new ArrayList<>();

	
	
	public Cliente() {
		//faço um construtor padrão sem argumentos
	}
	
	public Cliente(Integer id, String nome, String email, String cpfOuCnpj, TipoCliente tipo) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipo = tipo.getCod();
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
		return TipoCliente.toEnum(tipo);
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo.getCod();
	}
	
	 public List<Endereco> getEnderecos() {
		return enderecos;
	}
	
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	public Set<String> getTelefones() {
		return telefones;
	}
	
	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
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
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}

}
