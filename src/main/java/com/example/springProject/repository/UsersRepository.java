package com.example.springProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springProject.model.Users;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Boolean existsByUserName(String userName);
    Optional<Users> findByUserName(String userName);

}
