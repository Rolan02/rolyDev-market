package com.jalafoundation.apimarket.persistence.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable //esta
@Data
public class BuysProductPK implements Serializable {
    private Integer idBuys;
    private Integer idProduct;
}
