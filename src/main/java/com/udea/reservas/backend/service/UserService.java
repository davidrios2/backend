package com.udea.reservas.backend.service;

import com.udea.reservas.backend.model.User;
import com.udea.reservas.backend.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByCedula(String cedula) {
        return userRepository.findByCedula(cedula);
    }
}