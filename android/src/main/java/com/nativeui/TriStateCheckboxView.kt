package com.nativeui
import android.annotation.SuppressLint
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.state.ToggleableState
import com.facebook.react.uimanager.ThemedReactContext
import com.nativeui.views.AutoSizingComposable
import com.nativeui.views.NativeComposeView

@SuppressLint("ViewConstructor")
class TriStateCheckboxView(context: ThemedReactContext): NativeComposeView(context, withHostingView = true) {
    var state by mutableStateOf<ToggleableState>(ToggleableState.Off)
    var onClick: (() -> Unit)? = null
    var disabled by mutableStateOf<Boolean>(false)
    var onPress = mutableStateOf<(ToggleableState)>(ToggleableState.Off)

    @Composable
    override fun Content() {
        AutoSizingComposable(shadowNodeProxy) {
            DynamicTheme {
                TriStateCheckbox(
                    state = state,
                    onClick = onClick,
                    enabled = !disabled,
                )
            }
        }
    }
}