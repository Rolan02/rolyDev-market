package com.jalafoundation.apimarket.persistence;

import com.jalafoundation.apimarket.persistence.crud.ProductRepositoryCRUD;
import com.jalafoundation.apimarket.persistence.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository // esta clase se encarga de interactuar con la base de datos -- desde aca hacemos las operaciones que queremos aplicas a nuestras tablas
public class ProductRepository {

    @Autowired // los objetos que reciban esta operacion spring crea la instancia del objeto // solo podemos injectar componentes spring
    private ProductRepositoryCRUD productRepository;

    public List<Producto> getAll(){
        return (List<Producto>)productRepository.findAll();
    }
    public List<Producto> getByCategoty(int idCategory){
        return productRepository.findByidCategotyOrderByNameAsc(idCategory);
    }
    public Optional<List<Producto>> getCantity(int cantity){
        return productRepository.findByCantidadStockLessThanAndEstado(cantity,true);
    }
    public Optional<Producto> getProduct(int idProduct){
        return productRepository.findById(idProduct);
    }
    public Producto save(Producto producto){
        return productRepository.save(producto);
    }
    public void delete(int id){
        productRepository.deleteById(id);
    }
}
