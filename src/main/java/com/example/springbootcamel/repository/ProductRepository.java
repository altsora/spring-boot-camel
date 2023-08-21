package com.example.springbootcamel.repository;

import com.example.springbootcamel.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Vergun Alexander
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
