package com.example.samplecrudapi.apicrud.repo;

import com.example.samplecrudapi.apicrud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository <User, Integer> {

    Optional<User> findByEmail(String email);
}
