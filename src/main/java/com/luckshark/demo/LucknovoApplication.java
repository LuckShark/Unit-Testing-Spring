package com.luckshark.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.luckshark.demo.entities.Categoria;
import com.luckshark.demo.entities.Produto;
import com.luckshark.demo.repositories.CategoriaRepository;
import com.luckshark.demo.repositories.ProdutoRepository;

@SpringBootApplication
public class LucknovoApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriarepository;
	@Autowired
	private ProdutoRepository produtorepository;

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
	}
	
	
	


}
