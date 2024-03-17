package com.syed.reviewapp.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.syed.reviewapp.data.api.ApiClient
import com.syed.reviewapp.data.repository.ReviewsRepositoryImpl
import com.syed.reviewapp.data.util.Resource
import com.syed.reviewapp.databinding.FragmentReviewsBinding
import com.syed.reviewapp.domain.usecase.GetReviewsUseCase
import com.syed.reviewapp.presentation.viewmodel.ReviewsViewModel
import com.syed.reviewapp.presentation.viewmodel.ReviewsViewModelFactory

class ReviewsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ReviewsRecyclerViewAdapter
    private lateinit var viewModel: ReviewsViewModel
    private lateinit var progressBar: ProgressBar

    private var _binding: FragmentReviewsBinding? = null
    private val binding: FragmentReviewsBinding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentReviewsBinding.inflate(inflater, container, false )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val repository = ReviewsRepositoryImpl(ApiClient.apiService)
        val getReviewsUseCase = GetReviewsUseCase(repository)
        val viewModelFactory = ReviewsViewModelFactory(getReviewsUseCase)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ReviewsViewModel::class.java)
        recyclerView = binding.recyclerView
        progressBar = binding.progress
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = ReviewsRecyclerViewAdapter(mutableListOf())
        recyclerView.adapter = adapter


        viewModel.reviews.observe(viewLifecycleOwner, Observer { resource ->
            when(resource) {
                is Resource.Loading -> {
                    progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    progressBar.visibility = View.GONE
                    adapter.updateReviews(resource.response.reviews)
                }
                is Resource.Error -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(
                        context,
                        "Error fetching data: ${resource.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })
        viewModel.getReviews()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
