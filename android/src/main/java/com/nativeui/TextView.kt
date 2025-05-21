package com.nativeui

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.facebook.react.uimanager.ThemedReactContext
import com.nativeui.tategaki.BasicText
import com.nativeui.views.AutoSizingComposable
import com.nativeui.views.Direction
import com.nativeui.views.NativeComposeView
import java.util.EnumSet

@SuppressLint("ViewConstructor")
class TextView(context: ThemedReactContext) : NativeComposeView(context, withHostingView = true) {
    var text by mutableStateOf("")

    @Composable
    override fun Content() {
        AutoSizingComposable (
            shadowNodeProxy,
            axis = EnumSet.of(Direction.VERTICAL)
        ) {
            DynamicTheme {
                BasicText(text)
            }
        }
    }
}