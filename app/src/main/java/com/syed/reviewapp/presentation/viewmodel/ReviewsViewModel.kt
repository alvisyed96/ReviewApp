package com.syed.reviewapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.syed.reviewapp.data.util.Resource
import com.syed.reviewapp.domain.usecase.GetReviewsUseCase
import kotlinx.coroutines.launch

class ReviewsViewModel(private val getReviewsUseCase: GetReviewsUseCase) : ViewModel() {

    private val _reviews: MutableLiveData<Resource> = MutableLiveData()
    val reviews: LiveData<Resource> = _reviews

    fun getReviews() = viewModelScope.launch {
        getReviewsUseCase.execute().collect {
            _reviews.postValue(it)
        }
    }
}