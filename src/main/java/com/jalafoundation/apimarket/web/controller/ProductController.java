package com.jalafoundation.apimarket.web.controller;

import com.jalafoundation.apimarket.domain.service.ProductService;
import com.jalafoundation.apimarket.persistence.entity.Producto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController // Con esta anotacion estamos diciendo que esta clase sera el controlador de una api rest
@RequestMapping("/products")//que Path sera la petecion que le agamos
public class ProductController {
    @Autowired(required = true) // Autorizamos que este es un objeto de Spring
    private ProductService productService; // injectamos el servicio

    @GetMapping("/all")
    @ApiOperation("Get all superMarket product")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Producto>> getAll(){ //
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    @ApiOperation("Search a product with an ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Product not Found"),

    })
    public ResponseEntity<Producto> getProduct(@ApiParam(value = "the id of the product") @PathVariable("id") int productId){
        return productService.getProduct(productId).map(producto ->
                new ResponseEntity<>(producto , HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/categoty/{categotyId}")
    public ResponseEntity<List<Producto>> getByCategoty(@PathVariable("categoryId") int categotyId){
        return productService.getByCategoty(categotyId)
                .map(productos -> new ResponseEntity<>(productos , HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/save")
    public ResponseEntity<Producto> save(@RequestBody Producto product){
        return new ResponseEntity<>(productService.save(product) , HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int productId){
        if(productService.delete(productId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
