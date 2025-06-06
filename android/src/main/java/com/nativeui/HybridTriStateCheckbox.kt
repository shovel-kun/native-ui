package com.nativeui

import androidx.annotation.Keep
import androidx.compose.ui.state.ToggleableState
import com.facebook.proguard.annotations.DoNotStrip
import com.facebook.react.uimanager.ThemedReactContext
import com.margelo.nitro.nativeui.HybridTriStateCheckboxSpec
import com.margelo.nitro.nativeui.TriStateCheckboxState

@Keep
@DoNotStrip
class HybridTriStateCheckbox(val context: ThemedReactContext): HybridTriStateCheckboxSpec() {
    // View
    override val view = TriStateCheckboxView(context)

    // Props
    override var state: TriStateCheckboxState = TriStateCheckboxState.OFF
        set(value) {
            if (field == value) return
            field = value
            view.state = value.toToggleableState()
        }

    override var disabled: Boolean? = false
        set(value) {
            if (field == value || value == null) return
            field = value
            view.disabled = value
        }


    override var onPress: (() -> Unit)? = null
        set(value) {
            if (field == value || value == null) return
            field = value
            view.onClick = value
        }
}

fun TriStateCheckboxState.toToggleableState(): ToggleableState {
    return when (this) {
        TriStateCheckboxState.ON -> ToggleableState.On
        TriStateCheckboxState.OFF -> ToggleableState.Off
        TriStateCheckboxState.INDETERMINATE -> ToggleableState.Indeterminate
    }
}