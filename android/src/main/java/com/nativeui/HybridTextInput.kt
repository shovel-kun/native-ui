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
    override var label: String? = null
        set(value) {
            if (field == value) return
            field = value
//            view.setLabel(value)
        }
}
