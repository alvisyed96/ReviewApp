package com.syed.reviewapp.data.model

data class ReviewsResponse(
    val averageRating: Double,
    val reviews: List<Review>,
    val totalCount: Int
)