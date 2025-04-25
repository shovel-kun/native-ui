package com.nativeui

import android.graphics.Color
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
    private var _isRed = false
    override var isRed: Boolean
        get() = _isRed
        set(value) {
            _isRed = value
        }
}
