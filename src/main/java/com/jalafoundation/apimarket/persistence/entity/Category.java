package com.jalafoundation.apimarket.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategory;
    private String description;
    private Boolean state;
    @OneToMany(mappedBy = "category")
    private List<Producto> product;
}
