package com.example.pmacademyandroid_metelov_l13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.example.pmacademyandroid_metelov_l13.databinding.ActivityMainBinding
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupListeners()
    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupListeners() {
        binding.btnAction.setOnClickListener {
            hideButtonAndTextView()
            calculateNewValueAndShowButtonAndTextView()
        }
    }

    private fun hideButtonAndTextView() {
        binding.btnAction.visibility = View.GONE
        binding.tvCounter.visibility = View.GONE
    }

    private fun calculateNewValueAndShowButtonAndTextView() {
        showProgressBar()

        var currentCounterValue: Long = binding.tvCounter.text.toString().toLong()

        //progressBar must hide after (currentCounter + 1) / 10 seconds
        //it's equals (currentCounter + 1) * 100millis
        var timeOfAnimationInMillis: Long = (currentCounterValue + 1) * 100

        //set new value for TextView
        binding.tvCounter.text = "${(currentCounterValue + 1)}"

        Handler(Looper.getMainLooper()).postDelayed(
            {
                hideProgressBar()
                showButtonAndTextView()
            },
            (timeOfAnimationInMillis)
        )
    }

    private fun showProgressBar() {
        binding.pbAnimation.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        binding.pbAnimation.visibility = View.GONE
    }

    private fun showButtonAndTextView() {
        binding.btnAction.visibility = View.VISIBLE
        binding.tvCounter.visibility = View.VISIBLE
    }
}