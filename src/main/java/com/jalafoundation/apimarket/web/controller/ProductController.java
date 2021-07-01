package com.jalafoundation.apimarket.web.controller;

import com.jalafoundation.apimarket.domain.service.ProductService;
import com.jalafoundation.apimarket.persistence.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController // Con esta anotacion estamos diciendo que esta clase sera el controlador de una api rest
@RequestMapping("/products")//que Path sera la petecion que le agamos
public class ProductController {
    @Autowired // Autorizamos que este es un objeto de Spring
    private ProductService productService; // injectamos el servicio

    public List<Producto> getAll(){
        return productService.getAll();
    }
    public Optional<Producto> getProduct(int productId){
        return productService.getProduct(productId);
    }
    public Optional<List<Producto>> getByCategoty(int categotyId){
        return productService.getByCategoty(categotyId);
    }
    public Producto save(Producto product){
        return productService.save(product);
    }
    public boolean delete(int productId){
        return productService.delete(productId);
    }

}
