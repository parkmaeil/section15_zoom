package com.example.security.repository;

import com.example.security.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
