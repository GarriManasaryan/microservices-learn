package com.example.m2.port.adapters.backoffice.resource;

import com.example.m2.application.ProductService;
import com.example.m2.domain.Product;
import com.example.m2.port.adapters.persistence.PostgresqlProducts;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ProductResource {

    private final PostgresqlProducts postgresqlProducts;
    private final ProductService productService;

    public ProductResource(PostgresqlProducts postgresqlProducts, ProductService productService) {
        this.postgresqlProducts = postgresqlProducts;
        this.productService = productService;
    }

    @PostMapping("/api/products/{name}")
    public void save(@PathVariable(name = "name") String name){
        productService.save(name);
    }

    @GetMapping("/api/products")
    public List<Product> all(){
        return postgresqlProducts.all();
    }

}
