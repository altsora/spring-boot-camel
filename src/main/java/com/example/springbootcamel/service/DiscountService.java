package com.example.springbootcamel.service;

import com.example.springbootcamel.domain.Discount;
import com.example.springbootcamel.domain.Product;
import com.example.springbootcamel.repository.DiscountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

/**
 * @author Vergun Alexander
 */
@Service
@RequiredArgsConstructor
public class DiscountService {
    private final DiscountRepository discountRepository;
    private final ProductService productService;

    private final Random random = new Random();

    public Discount makeDiscount() {
        // create a discount
        Discount discount = new Discount();
        int discountRate = this.random.nextInt(100);
        discount.setAmount(discountRate);

        // select random product
        int productId = this.random.nextInt(3) + 1;
        Product product = productService.findById(productId);

        // set the discount to product and save
        int discountedPrice = product.getPrice() - (discountRate * product.getPrice() / 100);
        product.setDiscounted(discountedPrice);
        productService.save(product);

        discount.setProduct(product);
        return discount;
    }

    public Discount findDiscount(Integer id) {
        Optional<Discount> discount = discountRepository.findById(id);
        if (!discount.isPresent()) {
            throw new IllegalStateException("Discount could not found for given id:" + id);
        }
        return discount.get();
    }
}
