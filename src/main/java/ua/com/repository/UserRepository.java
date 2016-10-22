package ua.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{}
