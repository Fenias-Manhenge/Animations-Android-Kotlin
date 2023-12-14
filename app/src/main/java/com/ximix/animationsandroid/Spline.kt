package com.ximix.animationsandroid

import android.R
import android.content.Context
import android.graphics.Color
import android.icu.text.Normalizer2.Mode
import android.icu.text.Transliterator.Position
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.ximix.animationsandroid.databinding.ActivitySplineBinding
import io.github.sceneview.components.RenderableInstance
import io.github.sceneview.math.Rotation
import io.github.sceneview.math.Scale
import io.github.sceneview.nodes.ModelNode
import io.github.sceneview.nodes.RenderableNode


class Spline : AppCompatActivity() {

    private lateinit var binding: ActivitySplineBinding
    private lateinit var modelNode: ModelNode

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*
        binding.svSpline.addChildNode(
            ModelNode(
                position = Position(0, 0, 4),
                rotation = Rotation(y = 90.0f),
                scale = Scale(0.5f)
            )
        )

        lifecycleScope.launchWhenCreated {
            val modelInstance = modelNode
        }

        suspend fun loadModel(
            context: Context,
            glbFileLocation: String,
            autoAnimate: Boolean = true,
            autoScale: Boolean = false,
            centerOrigin: Position? = null,
            onError: ((error: Exception) -> Unit)? = null
        ):RenderableInstance?{
            return try {
                Position(0, 0,0)
                val model = GlBLoa
            }catch () {
            }
        }
         */

        binding.webView.loadUrl("file:///android_asset/spline.html")
        binding.webView.settings.apply {
            javaScriptEnabled = true
            loadWithOverviewMode = true
        }
    }

}