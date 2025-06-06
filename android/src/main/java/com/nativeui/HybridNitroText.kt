package com.nativeui

import androidx.annotation.Keep
import com.facebook.proguard.annotations.DoNotStrip
import com.facebook.react.uimanager.ThemedReactContext
import com.margelo.nitro.nativeui.HybridNitroTextSpec

@Keep
@DoNotStrip
class HybridNitroText(val context: ThemedReactContext): HybridNitroTextSpec() {
    // View
    override val view = TextView(context)

    // Props
    override var text: String? = null
        set(value) {
            if (field == value || value == null) return
            field = value
            view.text = value
        }
}
