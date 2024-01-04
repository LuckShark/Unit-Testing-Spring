package com.luckshark.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.luckshark.demo.entities.Categoria;
import com.luckshark.demo.entities.Cidade;
import com.luckshark.demo.entities.Cliente;
import com.luckshark.demo.entities.Endereco;
import com.luckshark.demo.entities.Estado;
import com.luckshark.demo.entities.Produto;
import com.luckshark.demo.entities.enums.TipoCliente;
import com.luckshark.demo.repositories.CategoriaRepository;
import com.luckshark.demo.repositories.CidadeRepository;
import com.luckshark.demo.repositories.ClienteRepository;
import com.luckshark.demo.repositories.EnderecoRepository;
import com.luckshark.demo.repositories.EstadoRepository;
import com.luckshark.demo.repositories.ProdutoRepository;

@SpringBootApplication
public class LucknovoApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriarepository;
	@Autowired
	private ProdutoRepository produtorepository;
	@Autowired
	private CidadeRepository cidaderepository;
	@Autowired
	private EstadoRepository estadorepository;
	@Autowired
	private ClienteRepository clienterepository;
	@Autowired
	private EnderecoRepository enderecorepository;

	public static void main(String[] args) {
		SpringApplication.run(LucknovoApplication.class, args);
	}
	
	@Override
    public void run(String... args) throws Exception {
		Categoria categoria1 = new Categoria(null,"Informatica");
		Categoria categoria2 = new Categoria(null,"Tecnologia");
		
		Produto produto1 = new Produto(null,"Computador",2500.00);
		Produto produto2 = new Produto(null,"Steam Deck", 3100.00);
		Produto produto3 = new Produto(null,"PlayStation5", 5000.00);
		
		categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
		categoria2.getProdutos().addAll(Arrays.asList(produto2));

		produto1.getCategorias().addAll(Arrays.asList(categoria1));
		produto2.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
		produto3.getCategorias().addAll(Arrays.asList(categoria1));
		
		categoriarepository.saveAll(Arrays.asList(categoria1, categoria2));
		produtorepository.saveAll(Arrays.asList(produto1, produto2, produto3));
		
		
		Estado estado1 = new Estado(null, "Ceará");
		Estado estado2 = new Estado(null, "São Paulo");
		
		Cidade cidade1 = new Cidade(null, "Fortaleza", estado1);
		Cidade cidade2 = new Cidade(null, "Campinas", estado2);
		Cidade cidade3 = new Cidade(null, "Sobral", estado2);
		
		estado1.getCidades().add(cidade1);
		estado2.getCidades().addAll(Arrays.asList(cidade2, cidade3));
		
		estadorepository.saveAll(Arrays.asList(estado1, estado2));
		cidaderepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));
		
		Cliente cliente1 = new Cliente(null, "Igor", "sesasenior@sesa.com", "12312309495", TipoCliente.PESSOAFISICA);
		cliente1.getTelefones().addAll(Arrays.asList("123456789", "09876543456"));
		
		Endereco endereco1 = new Endereco(null, "Rua Parangaba Horrível", "666", "Cheiro do queijo", "Parangaba", "6660690666", cliente1, cidade1);
		Endereco endereco2 = new Endereco(null, "Rua José Crime Walter", "69", "Barra pesada", "José Walter", "24024", cliente1, cidade2);

		clienterepository.saveAll(Arrays.asList(cliente1));
		enderecorepository.saveAll(Arrays.asList(endereco1, endereco2));
		
	
	}
	
	
	


}
