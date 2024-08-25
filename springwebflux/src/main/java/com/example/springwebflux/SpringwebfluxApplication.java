package com.example.springwebflux;

import com.example.springwebflux.dto.ItemDTO;
import com.example.springwebflux.mappers.ItemAndItemDTO;
import com.example.springwebflux.models.Item;
import com.example.springwebflux.repositories.ItemRepository;
import com.example.springwebflux.services.impl.ItemServiceImpl;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringwebfluxApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringwebfluxApplication.class, args);
	}

}
