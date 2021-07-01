package com.jalafoundation.apimarket.domain.service;

import com.jalafoundation.apimarket.domain.repository.ProductRepository;
import com.jalafoundation.apimarket.persistence.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service  //@Component  es lo mismo pero el @Service hace una mejor referencia
public class ProductService {

    @Autowired(required = true)
    private ProductRepository productRepository;

    public List<Producto> getAll(){
        return  productRepository.getAll();
    }
    public Optional<Producto> getProduct(int productId){
        return productRepository.getProduct(productId);
    }
    public Optional<List<Producto>> getByCategoty(int categoryId){
        return productRepository.getByCategory(categoryId);
    }
    public Producto save(Producto product){
        return  productRepository.save(product);
    }
    public boolean delete(int productId){
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }
    public boolean delete2(int productId){
        if(getProduct(productId).isPresent()){
            productRepository.delete(productId);
            return true;
        } else {
            return false;
        }
    }
}
