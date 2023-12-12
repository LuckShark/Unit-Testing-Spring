package com.luckshark.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.luckshark.demo.entities.Categoria;
import com.luckshark.demo.repositories.CategoriaRepository;

@SpringBootApplication
public class LucknovoApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriarepository;

	public static void main(String[] args) {
		SpringApplication.run(LucknovoApplication.class, args);
	}
	
	@Override
    public void run(String... args) throws Exception {
		Categoria categoria1 = new Categoria(null,"Informatica");
		Categoria categoria2 = new Categoria(null,"Tecnologia");
		categoriarepository.saveAll(Arrays.asList(categoria1, categoria2));
	}

}
