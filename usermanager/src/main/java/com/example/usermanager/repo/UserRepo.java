package com.example.usermanager.repo;

import com.example.usermanager.model.UserSpringModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserSpringModel, Long> {

    void deleteUserById(Long id);

    Optional<UserSpringModel> findUserById(Long id);
}
