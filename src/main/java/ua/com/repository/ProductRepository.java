package ua.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{}
