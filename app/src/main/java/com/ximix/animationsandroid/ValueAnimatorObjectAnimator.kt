package com.ximix.animationsandroid

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView
import com.ximix.animationsandroid.databinding.ActivityFadeBinding

class ValueAnimatorObjectAnimator : AppCompatActivity() {

    private lateinit var ivQuiz: ImageView

    lateinit var binding: ActivityFadeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityFadeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        ivQuiz = binding.xiquiz

        //fade()
        backDrop()
        objectAnimatorDemo()
    }

    private fun backDrop(){
        // current position
        val finalPosition = ivQuiz.y

        // new position on the y axis
        val startPosition = finalPosition + 500

        ivQuiz.y = startPosition

        val animator = ValueAnimator.ofFloat(startPosition, finalPosition)
        animator.duration = 7000
        animator.interpolator = DecelerateInterpolator()

        animator.addUpdateListener {
            val animatedValue = it.animatedValue as Float
            ivQuiz.translationY = animatedValue
        }

        animator.start()
    }

    private fun fade(){
        ivQuiz.alpha = 0F

        val animator = ValueAnimator.ofFloat(0f, 1f)
        animator.duration = 5000
        animator.interpolator = AccelerateInterpolator()

        animator.addUpdateListener {
            val animatedValue = it.animatedValue as Float
            ivQuiz.alpha = animatedValue
            ivQuiz.scaleX = animatedValue
            ivQuiz.scaleY = animatedValue
        }
        animator.start()
    }

    private fun objectAnimatorDemo(){
        val animator = ObjectAnimator.ofFloat(binding.tvFuture, "alpha",0f, 1f)
        animator.duration = 10000
        animator.start()
    }
}