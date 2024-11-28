package com.example.security.service;

import com.example.security.entity.Customer;
import com.example.security.entity.Review;
import com.example.security.entity.Role;
import com.example.security.repository.MemberRepository;
import com.example.security.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public void reviewDelete(Long reviewId){
        reviewRepository.deleteById(reviewId);
    }
}
