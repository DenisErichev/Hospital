package com.springRest.DAO;

import com.springRest.enitity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import com.springRest.enitity.Users;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
}
