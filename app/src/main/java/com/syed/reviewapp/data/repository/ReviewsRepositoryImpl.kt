package com.syed.reviewapp.data.repository

import com.syed.reviewapp.data.api.ApiService
import com.syed.reviewapp.data.util.Resource
import com.syed.reviewapp.domain.repository.ReviewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ReviewsRepositoryImpl(private val apiService: ApiService) : ReviewsRepository {
    override suspend fun getReviews(): Flow<Resource> {
        return flow {
            try {
                emit(Resource.Loading)
                val response = apiService.getReviews()
                if (response.isSuccessful && response.body() != null) {
                    emit(Resource.Success(response.body()!!))
                } else {
                    emit(Resource.Error(response.message()))
                }
            } catch (e: Exception) {
                emit(Resource.Error(e.message.toString()))
            }
        }
    }
}