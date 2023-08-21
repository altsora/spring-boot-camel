package com.example.springbootcamel.domain;

import lombok.Data;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author Vergun Alexander
 */
@Entity
@Table(name = "products")
@NamedQuery(name = "discounted-products",
        query = "select product from Product product where product.discounted IS NOT NULL")
@Data
public class Product {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    private Integer price;

    private Integer discounted;
}
