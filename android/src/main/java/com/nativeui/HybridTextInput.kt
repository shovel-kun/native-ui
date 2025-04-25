package com.nativeui

import androidx.annotation.Keep
import com.facebook.proguard.annotations.DoNotStrip
import com.facebook.react.uimanager.ThemedReactContext
import com.margelo.nitro.nativeui.HybridTextInputSpec

@Keep
@DoNotStrip
class HybridTextInput(val context: ThemedReactContext): HybridTextInputSpec() {
    // View
    override val view = TextInputView(context)

    // Props
    override var value: String? = ""
        get() = view.value
        set(value) {
            if (field == value || value == null) return
            field = value
            view.value = value
        }

    override var label: String? = null
        set(value) {
            if (field == value) return
            field = value
            view.label = value
        }

    override var placeholder: String? = null
        set(value) {
            if (field == value) return
            field = value
            view.placeholder = value
        }

    override var onValueChange: ((String) -> Unit)? = null
        set(value) {
            if (field == value) return
            field = value
            view.onValueChange = value
        }
}
