package com.example.security.controller;

import com.example.security.entity.Review;
import com.example.security.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/manager/manage-reviews")
    public String showReviewList(Model model) {
       List<Review> reviews = reviewService.getAllReviews();
        // Add the reviews to the model
        model.addAttribute("reviews", reviews);
        // Return the HTML template name
        return "review/reviewList";
    }

    @GetMapping("/reviewAdd")
    public String reviewAdd() {
        return "review/reviewRegister";
    }
}
