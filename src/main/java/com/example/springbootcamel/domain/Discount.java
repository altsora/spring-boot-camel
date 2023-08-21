package com.example.springbootcamel.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Vergun Alexander
 */
@Entity
@Table(name = "discounts")
@Data
public class Discount {
    @Id
    @GeneratedValue
    private int id;

    private Integer amount;

    @OneToOne
    private Product product;
}
