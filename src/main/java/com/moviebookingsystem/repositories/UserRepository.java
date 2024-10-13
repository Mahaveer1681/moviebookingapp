package com.moviebookingsystem.repositories;

import com.moviebookingsystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    @Override
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);

    @Override
    User save(User user);
}
