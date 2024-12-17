package org.example.ordermicroservice.feign;

import org.example.ordermicroservice.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ProductMicroService",url = "localhost:8082/products")
public interface ProductClientFeign {

    @GetMapping("/{id}")
    ProductDto findById(@PathVariable("id") Long id);
}
