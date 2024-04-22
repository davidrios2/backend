package com.udea.reservas.backend.respository;

import com.udea.reservas.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByCedula (String cedula);

}
