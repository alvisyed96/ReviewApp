package com.syed.reviewapp.data.api

import com.syed.reviewapp.data.api.ApiClient.END_POINT
import com.syed.reviewapp.data.model.ReviewsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(END_POINT)
    suspend fun getReviews(): Response<ReviewsResponse>
}