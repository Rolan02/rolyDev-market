package com.jalafoundation.apimarket.web.controller;

import com.jalafoundation.apimarket.domain.service.ProductService;
import com.jalafoundation.apimarket.persistence.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Con esta anotacion estamos diciendo que esta clase sera el controlador de una api rest
@RequestMapping("/products")//que Path sera la petecion que le agamos
public class ProductController {
    @Autowired(required = true) // Autorizamos que este es un objeto de Spring
    private ProductService productService; // injectamos el servicio

    @GetMapping("/all")
    public List<Producto> getAll(){
        return productService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Producto> getProduct(@PathVariable("id") int productId){
        return productService.getProduct(productId);
    }
    @GetMapping("/categoty/{categotyId}")
    public Optional<List<Producto>> getByCategoty(@PathVariable("categoryId") int categotyId){
        return productService.getByCategoty(categotyId);
    }
    @PostMapping("/save")
    public Producto save(@RequestBody Producto product){
        return productService.save(product);
    }
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int productId){
        return productService.delete(productId);
    }

}
