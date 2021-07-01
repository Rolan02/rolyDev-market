package com.jalafoundation.apimarket.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name ="client")
public class Client {

    private String id;
    private String name;
    private String lastName;
    private Long cellPhone;
    private String address;
    private String email;
    @OneToMany(mappedBy = "client")
    private List<Buys> buys;
}
