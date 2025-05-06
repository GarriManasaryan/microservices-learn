//package com.example.m1.port.adapters.backoffice.resource;
//
//import com.example.m1.domain.Product;
//import com.example.m1.port.adapters.persistence.PostgresqlProducts;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin("*")
//public class ProductResource {
//
//    private final PostgresqlProducts postgresqlProducts;
//
//    public ProductResource(PostgresqlProducts postgresqlProducts) {
//        this.postgresqlProducts = postgresqlProducts;
//    }
//
//    @PostMapping("/api/products/{name}")
//    public void save(@PathVariable(name = "name") String name){
//        postgresqlProducts.save(name);
//    }
//
//    @GetMapping("/api/products")
//    public List<Product> all(){
//        return postgresqlProducts.all();
//    }
//
//}
