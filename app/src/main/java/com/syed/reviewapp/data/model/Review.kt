package com.syed.reviewapp.data.model

data class Review(
    val activityId: Int,
    val author: Author,
    val created: String,
    val enjoyment: String,
    val id: Int,
    val isAnonymous: Boolean,
    val isTestData: Boolean,
    val language: String,
    val message: String,
    val optionId: Int,
    val rating: Int,
    val ratings: List<Rating>,
    val title: String,
    val travelerType: String
)