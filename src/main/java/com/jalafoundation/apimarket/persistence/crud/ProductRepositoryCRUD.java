package com.jalafoundation.apimarket.persistence.crud;

import com.jalafoundation.apimarket.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryCRUD extends CrudRepository<Producto, Integer> {

    @Query(value = "SELECT * FROM products WHERE idCategory = ?",nativeQuery = true) // esta es la forma de hacer una query de forma nativa
    List<Producto> findByidCategotyOrderByNameAsc(int idCategory); // esta de forma con query Methods

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantStock,boolean state);
}
