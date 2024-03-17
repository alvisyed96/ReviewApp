package com.syed.reviewapp.domain.repository

import com.syed.reviewapp.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface ReviewsRepository {

    suspend fun getReviews() : Flow<Resource>
}