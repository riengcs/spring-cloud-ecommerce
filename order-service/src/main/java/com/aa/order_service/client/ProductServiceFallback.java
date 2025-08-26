package com.aa.order_service.client;

import com.aa.order_service.dto.ProductDTO;
import com.aa.order_service.exception.ProductServiceUnavailableException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductServiceFallback implements ProductServiceClient {

    @Override
    public Optional<ProductDTO> getProductById(Long id) {
        throw new ProductServiceUnavailableException(id);
    }

}
