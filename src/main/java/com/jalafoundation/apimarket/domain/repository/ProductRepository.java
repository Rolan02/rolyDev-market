package com.jalafoundation.apimarket.domain.repository;

import com.jalafoundation.apimarket.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Producto> getAll();
    Optional<List<Producto>> getByCategory(int categotyId);
    Optional<List<Producto>> getScarseProduct(int quantity);
    Optional<Producto> getProduct(int productId);
    Producto save(Producto product);
    void delete(int productId);


}
