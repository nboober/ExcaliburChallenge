package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDateRepository extends JpaRepository<OrderDate, Long> {
}
