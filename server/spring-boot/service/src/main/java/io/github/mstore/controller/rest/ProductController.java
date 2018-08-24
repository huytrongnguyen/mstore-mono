package io.github.mstore.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.mstore.catalog.Product;
import io.github.mstore.catalog.ProductRepository;

@RestController
@RequestMapping("api/products")
public class ProductController {
  private ProductRepository productRepo;

  @Autowired
  public ProductController(ProductRepository productRepo) {
    this.productRepo = productRepo;
  }

  @GetMapping
  public List<Product> index() {
    return productRepo.findAll();
  }

  @GetMapping("{id}")
  public Product detail(@PathVariable("id") String id) {
    Product product = productRepo.findById(id).get();
    return product;
  }
}