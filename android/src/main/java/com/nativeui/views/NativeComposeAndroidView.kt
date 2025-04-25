package com.nativeui.views

import android.view.View
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.facebook.react.uimanager.PixelUtil.pxToDp

/**
 * An ExpoComposeView for [AndroidView] wrapping with existing view
 */
class NativeComposeAndroidView(private val view: View) : NativeComposeView(view.context) {
    @Composable
    override fun Content() {
        AndroidView(
            factory = { view },
            modifier = Modifier.size(view.width.toFloat().pxToDp().dp, view.height.toFloat().pxToDp().dp)
        )
    }
}