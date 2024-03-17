package com.syed.reviewapp.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.syed.reviewapp.R
import com.syed.reviewapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            val reviewsFragment = ReviewsFragment()
            supportFragmentManager.beginTransaction()
                .replace(binding.container.id, reviewsFragment).commit()
        }
    }
}
