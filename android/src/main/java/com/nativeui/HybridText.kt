package com.nativeui

import androidx.annotation.Keep
import com.facebook.proguard.annotations.DoNotStrip
import com.facebook.react.uimanager.ThemedReactContext
import com.margelo.nitro.nativeui.HybridTextSpec

@Keep
@DoNotStrip
class HybridText(val context: ThemedReactContext): HybridTextSpec() {
    // View
    override val view = TextView(context)

    // Props
    override var text: String = ""
        set(value) {
            field = value
            view.text = value
        }
}
