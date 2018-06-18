package com.innovation.microservices.microservicesuserservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.innovation.microservices.microservicesuserservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	@Query("SELECT t FROM User t where t.email = ?1 AND t.password = ?2")
    public Optional<User> findByEmailAndPassword(String email, String password);
}
