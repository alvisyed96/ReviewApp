package com.syed.reviewapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.syed.reviewapp.domain.usecase.GetReviewsUseCase

class ReviewsViewModelFactory(private val getReviewsUseCase: GetReviewsUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ReviewsViewModel::class.java)) {
            return ReviewsViewModel(getReviewsUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}