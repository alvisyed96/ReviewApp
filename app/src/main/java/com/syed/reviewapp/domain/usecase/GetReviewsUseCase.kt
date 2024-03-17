package com.syed.reviewapp.domain.usecase

import com.syed.reviewapp.domain.repository.ReviewsRepository

class GetReviewsUseCase(private val repository: ReviewsRepository) {

    suspend fun execute() = repository.getReviews()
}