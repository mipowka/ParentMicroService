package org.example.ordermicroservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.ordermicroservice.dto.ProductDto;
import org.example.ordermicroservice.dto.UserDto;
import org.example.ordermicroservice.feign.ProductClientFeign;
import org.example.ordermicroservice.feign.UserClientFeign;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final ProductClientFeign productClientFeign;
    private final UserClientFeign userClientFeign;

    @GetMapping("/create")
    public ResponseEntity<String> createOrder(@RequestParam Long userId, @RequestParam Long productId) {
        UserDto userById = userClientFeign.findById(userId);
        ProductDto productById = productClientFeign.findById(productId);
        return ResponseEntity.ok("Order created successfully" + userById.getName() + " " + productById.getName());
    }
}
