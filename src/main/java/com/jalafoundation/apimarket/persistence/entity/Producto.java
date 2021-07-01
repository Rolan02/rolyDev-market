package com.jalafoundation.apimarket.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "productos")
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduct;
    private String name;
    private Integer idCategory;
    private String barCode;
    private Double priceVent;
    private Integer cantStock;
    private Boolean state;

    @ManyToOne
    @JoinColumn(name = "idCategory", insertable = false , updatable = false) // a travez de esta relacion no vamos a actualizar o borrar una nueva categoria solo nos sirve para recuperr la relacion
    private Category category;

}
