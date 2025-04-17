package com.shop.controller;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.javapoet.ClassName;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.model.Product;
import com.shop.repository.ProductRepository;

@RestController
@RequestMapping("/api/test")
public class TestController {

	private static final Logger logger = LoggerFactory.getLogger(ClassName.class);
	
	private final ProductRepository productRepository;
	
	public TestController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@GetMapping("/products")
	public List<Product> testApi() {
		
		logger.debug("testing the db connection wirth rest api");
		List<Product> list = productRepository.findAll();
		logger.debug(list.toString());
		return list;
	}
	
}
