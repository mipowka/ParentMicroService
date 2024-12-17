package org.example.usermicroservice.service;

import lombok.RequiredArgsConstructor;
import org.example.usermicroservice.entity.User;
import org.example.usermicroservice.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findUserById(Long id){
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("User Not Found"));
    }
}
