package ua.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.entity.Offer;

public interface OfferRepository extends JpaRepository<Offer, Long>{}