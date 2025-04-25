package com.nativeui.views

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.core.view.size

/**
 * A base class that should be used by compose views.
 */
abstract class NativeComposeView (
    context: Context,
    private val withHostingView: Boolean = false
) : NativeView(context) {

    @Composable
    abstract fun Content()

    override val shouldUseAndroidLayout = withHostingView

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if (shouldUseAndroidLayout) {
            // In case of issues there's an alternative solution in previous commits at https://github.com/expo/expo/pull/33759
            if (!isAttachedToWindow) {
                setMeasuredDimension(widthMeasureSpec, heightMeasureSpec)
                return
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    @Composable
    protected fun Children() {
        if (withHostingView) {
            return Content()
        }

        for (index in 0..<this.size) {
            val child = getChildAt(index) as? NativeComposeView ?: continue
            child.Content()
        }
    }

    init {
        if (withHostingView) {
            addComposeView()
        } else {
            this.visibility = GONE
            this.setWillNotDraw(true)
        }
    }

    private fun addComposeView() {
        val composeView = ComposeView(context).also {
            it.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
            it.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            it.setContent {
                Children()
            }
            it.addOnAttachStateChangeListener(object : OnAttachStateChangeListener {
                override fun onViewAttachedToWindow(v: View) {
                    it.disposeComposition()
                }

                override fun onViewDetachedFromWindow(v: View) = Unit
            })
        }
        addView(composeView)
    }

    override fun addView(child: View, index: Int, params: ViewGroup.LayoutParams) {
        val view = if (child !is NativeComposeView && child !is ComposeView) {
            NativeComposeAndroidView(child)
        } else {
            child
        }
        super.addView(view, index, params)
    }
}