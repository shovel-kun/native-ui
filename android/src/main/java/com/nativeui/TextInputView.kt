package com.nativeui

import android.annotation.SuppressLint
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.facebook.react.uimanager.ThemedReactContext
import com.nativeui.views.AutoSizingComposable
import com.nativeui.views.Direction
import com.nativeui.views.NativeComposeView
import java.util.EnumSet

@SuppressLint("ViewConstructor")
class TextInputView(context: ThemedReactContext): NativeComposeView(context, withHostingView = true )  {
    var label by mutableStateOf<String?>(null)

    @Composable
    override fun Content() {
        DynamicTheme {
            AutoSizingComposable(shadowNodeProxy, axis = EnumSet.of(Direction.VERTICAL)) {
                OutlinedTextField(
                    state = rememberTextFieldState(),
                    lineLimits = TextFieldLineLimits.SingleLine,
                    placeholder = { Text("Placeholder") },
                    label = label?.let { { Text(it) } },
                )
            }
        }
    }
}