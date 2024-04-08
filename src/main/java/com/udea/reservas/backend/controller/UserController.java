package com.udea.reservas.backend.controller;

import com.udea.reservas.backend.exception.UserNotFoundException;
import com.udea.reservas.backend.model.User;
import com.udea.reservas.backend.respository.UserRepository;
import com.udea.reservas.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping("/user")
    User newUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    List<User> all() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    User one(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @GetMapping("/user/cedula/{cedula}")
    public User getUserByCedula(@PathVariable String cedula) {
        return userService.getUserByCedula(cedula);
    }

    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    Optional.ofNullable(newUser.getName()).ifPresent(user::setName);
                    Optional.ofNullable(newUser.getLastName()).ifPresent(user::setLastName);
                    Optional.ofNullable(newUser.getEmail()).ifPresent(user::setEmail);
                    Optional.ofNullable(newUser.getPhoneNumber()).ifPresent(user::setPhoneNumber);
                    Optional.ofNullable(newUser.getCedula()).ifPresent(user::setCedula);
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id) {
        if(!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "User deleted successfully!";
    }


}
