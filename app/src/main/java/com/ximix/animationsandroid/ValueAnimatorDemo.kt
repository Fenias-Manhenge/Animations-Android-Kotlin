package com.ximix.animationsandroid

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView
import com.ximix.animationsandroid.databinding.ActivityFadeBinding

class ValueAnimatorDemo : AppCompatActivity() {

    lateinit var ivXiquiz: ImageView

    lateinit var binding: ActivityFadeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityFadeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        ivXiquiz = binding.xiquiz

        //fade()
        backDrop()
    }

    private fun backDrop(){
        // current position
        val finalPosition = ivXiquiz.y

        // new position on the y axis
        val startPosition = finalPosition + 500

        ivXiquiz.y = startPosition

        val animator = ValueAnimator.ofFloat(startPosition, finalPosition)
        animator.duration = 10000
        animator.interpolator = DecelerateInterpolator()

        animator.addUpdateListener {
            val animatedValue = it.animatedValue as Float
            ivXiquiz.translationY = animatedValue
        }

        animator.start()
    }

    private fun fade(){
        ivXiquiz.alpha = 0F

        val animator = ValueAnimator.ofFloat(0f, 1f)
        animator.duration = 5000
        animator.interpolator = AccelerateInterpolator()

        animator.addUpdateListener {
            val animatedValue = it.animatedValue as Float
            ivXiquiz.alpha = animatedValue
            ivXiquiz.scaleX = animatedValue
            ivXiquiz.scaleY = animatedValue
        }
        animator.start()
    }
}