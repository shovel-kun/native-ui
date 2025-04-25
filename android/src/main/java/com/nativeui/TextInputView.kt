package com.nativeui

import android.annotation.SuppressLint
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import com.facebook.react.uimanager.ThemedReactContext
import com.nativeui.views.AutoSizingComposable
import com.nativeui.views.Direction
import com.nativeui.views.NativeComposeView
import java.util.EnumSet

@SuppressLint("ViewConstructor")
class TextInputView(context: ThemedReactContext): NativeComposeView(context, withHostingView = true )  {
    var value by mutableStateOf<String>("")
    var label by mutableStateOf<String?>(null)
    var placeholder by mutableStateOf<String?>(null)
    var onValueChange by mutableStateOf<((String) -> Unit)?>({})

    @Composable
    override fun Content() {
//        val textFieldState = rememberTextFieldState(
//            initialText = value,
//        )
//
//        LaunchedEffect(Unit) {
//            snapshotFlow {
//                textFieldState.text
//            }.collect { value ->
//                onValueChange(value.toString())
//            }
//        }

        DynamicTheme {
            AutoSizingComposable(shadowNodeProxy, axis = EnumSet.of(Direction.VERTICAL)) {
                OutlinedTextField(
                    value = value,
                    onValueChange = {
                        value = it
                        onValueChange?.invoke(it)
                    },
                    placeholder = placeholder?.let { { Text(it) } },
                    label = label?.let { { Text(it) } },
                )
                //                OutlinedTextField(
                //                    state = rememberTextFieldState(),
                //                    lineLimits = TextFieldLineLimits.SingleLine,
                //                    placeholder = placeholder?.let { { Text(it) } },
                //                    label = label?.let { { Text(it) } },
                //                )
            }
        }
    }
}