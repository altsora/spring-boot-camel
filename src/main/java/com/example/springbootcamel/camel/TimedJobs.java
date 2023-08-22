package com.example.springbootcamel.camel;

import com.example.springbootcamel.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author Vergun Alexander
 */
@Component
@RequiredArgsConstructor
class TimedJobs extends RouteBuilder {
    private final DiscountService discountService;

    @Override
    public void configure() {
        from("timer:new-discount?delay=1000&period={{discount.newDiscountPeriod:2000}}")
                .routeId("make-discount")
//                .bean("discountService", "makeDiscount")
                .bean(discountService, "makeDiscount")
                .to("jpa:org.apache.camel.example.spring.boot.rest.jpa.Discount")
                .log("Created %${body.amount} discount for ${body.product.name}");

        // additional route will be added in the next step
        from("jpa:org.apache.camel.example.spring.boot.rest.jpa.Product"
                + "?namedQuery=discounted-products"
                + "&delay={{discount.listDiscountPeriod:6000}}"
                + "&consumeDelete=false")
                .routeId("list-discounted-products")
                .log("Discounted product ${body.name}. Price dropped from ${body.price} to ${body.discounted}");
    }
}
