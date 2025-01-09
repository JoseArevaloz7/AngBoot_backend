package com.jg.book.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User>  findByEmail(String email);
}
