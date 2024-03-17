package com.syed.reviewapp.data.util

import com.syed.reviewapp.data.model.ReviewsResponse

sealed class Resource {
    class Success(val response: ReviewsResponse) : Resource()
    class Error(val message: String) : Resource()
    object Loading : Resource()
}