package com.example.springbootcamel.repository;

import com.example.springbootcamel.domain.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Vergun Alexander
 */
@Repository
public interface DiscountRepository extends JpaRepository<Discount, Integer> {
}
