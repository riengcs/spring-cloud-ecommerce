package com.aa.order_service.client;

import com.aa.order_service.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
    name = "product-service",
    fallback = ProductServiceFallback.class
)
public interface ProductServiceClient {

    @GetMapping("/products/{id}")
    Optional<ProductDTO> getProductById(@PathVariable Long id);
}
