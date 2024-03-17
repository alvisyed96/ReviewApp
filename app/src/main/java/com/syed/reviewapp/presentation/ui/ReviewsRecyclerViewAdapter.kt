package com.syed.reviewapp.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.syed.reviewapp.data.model.Review
import com.syed.reviewapp.databinding.RowReviewsBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ReviewsRecyclerViewAdapter(private val reviews : MutableList<Review>) :
    RecyclerView.Adapter<ReviewsRecyclerViewAdapter.ReviewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewsViewHolder {
        val binding: RowReviewsBinding =
            RowReviewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReviewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewsViewHolder, position: Int) {
        holder.bind(reviews[position])
    }

    override fun getItemCount(): Int {
        return reviews.size
    }

    fun updateReviews(review: List<Review>) {
        reviews.clear()
        reviews.addAll(review)
        notifyDataSetChanged()
    }

    inner class ReviewsViewHolder(val binding: RowReviewsBinding) : ViewHolder(binding.root) {
        fun bind(reviewItems: Review) {
            binding.dateText.text = LocalDateTime.parse(
                reviewItems.created,
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssz")
            ).format(DateTimeFormatter.ofPattern("MMM dd, yyyy"))

            binding.author.text = reviewItems.author.fullName + "-" + reviewItems.author.country
            binding.ratingBar.rating = reviewItems.rating.toFloat()
            binding.message.text = reviewItems.message
        }

    }
}