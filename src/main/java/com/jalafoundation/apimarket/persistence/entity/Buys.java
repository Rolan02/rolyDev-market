package com.jalafoundation.apimarket.persistence.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "compras")
@Data

public class Buys {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBuys;
    private String idClient;
    private LocalDateTime date;
    private String mediaPage;
    private String stare;
    @ManyToOne
    @ManyToOne
    @ManyToOne
    @ManyToOne
    @ManyToOne
    @ManyToOne
    @ManyToOne
    @ManyToOne
    @ManyToOne
    @ManyToOne
    @ManyToOne
    @ManyToOne
    @ManyToOne
    @ManyToOne
    @ManyToOne

    @JoinColumn(name = "idClient", insertable = true, updatable = false)
    private Client client;
    private String comment;
    @OneToMany
            (mappedBy = "producto")
    private List<BuysProduct> product;

}
