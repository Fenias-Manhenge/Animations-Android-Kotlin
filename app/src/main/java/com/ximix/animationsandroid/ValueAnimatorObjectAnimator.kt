package com.ximix.animationsandroid

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.ximix.animationsandroid.databinding.ActivityFadeBinding

class ValueAnimatorObjectAnimator : AppCompatActivity() {

    private lateinit var ivQuiz: ImageView
    private lateinit var rbStar: RatingBar
    private lateinit var tvFuture: TextView

    private lateinit var binding: ActivityFadeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityFadeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        ivQuiz = binding.xiquiz
        rbStar = binding.rbStar
        tvFuture = binding.tvFuture

        fade()
        backDrop()
        objectAnimatorDemo()
    }

    private fun backDrop(){
        // current position
        val finalPosition = rbStar.y

        // new position on the y axis
        val startPosition = finalPosition + 400

        rbStar.y = startPosition
        //rbStar.alpha = 0f

        val animator = ValueAnimator.ofFloat(startPosition, finalPosition)
        animator.duration = 5500
        animator.interpolator = DecelerateInterpolator()

        animator.addUpdateListener {
            val animatedValue = it.animatedValue as Float
            rbStar.translationY = animatedValue
        }

        animator.start()
    }

    private fun fade(){
        ivQuiz.alpha = 0F

        val animator = ValueAnimator.ofFloat(0f, 1f)
        animator.duration = 5000
        animator.interpolator = AccelerateDecelerateInterpolator()

        animator.addUpdateListener {
            val animatedValue = it.animatedValue as Float
            ivQuiz.alpha = animatedValue
            ivQuiz.scaleX = animatedValue
            ivQuiz.scaleY = animatedValue
        }
        animator.start()
    }

    // just animate single property
    private fun objectAnimatorDemo(){
        val finalPositionTV = tvFuture.x
        val  startPositionTV = finalPositionTV - 700
        tvFuture.x = startPositionTV

        // I chose "alpha"
        val animator = ObjectAnimator.ofFloat(binding.tvFuture, "translationX",startPositionTV, finalPositionTV)
        animator.duration = 5000
        animator.start()
    }
}