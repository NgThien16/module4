package org.example.ss8_validation.repository;

import org.example.ss8_validation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
