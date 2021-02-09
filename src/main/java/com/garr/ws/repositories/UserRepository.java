package com.garr.ws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garr.ws.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
