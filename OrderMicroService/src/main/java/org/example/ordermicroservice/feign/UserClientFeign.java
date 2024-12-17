package org.example.ordermicroservice.feign;

import org.example.ordermicroservice.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "UserMicroService",url = "localhost:8081/users")
public interface UserClientFeign {

    @GetMapping("/{id}")
    UserDto findById(@PathVariable("id") Long id);
}
