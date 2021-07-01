package com.jalafoundation.apimarket.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "buysProduct")
public class BuysProduct {
    @EmbeddedId
    private BuysProductPK id;

    private Integer cant;
    private Double total;
    private Boolean state;
    @ManyToOne  // todas las anotaciones que tengan join colum que tengas manyTuOne deben llevar la modificacion como falsa
    @JoinColumn(name = "idBuys",insertable = false, updatable = false)
    private Buys buys;
    @ManyToOne
    @JoinColumn(name = "idProduct", insertable = false,updatable = false)
    private Producto producto;
}
