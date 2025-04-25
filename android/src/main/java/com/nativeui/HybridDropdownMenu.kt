package com.nativeui

import androidx.annotation.Keep
import com.facebook.proguard.annotations.DoNotStrip
import com.facebook.react.uimanager.ThemedReactContext
import com.margelo.nitro.nativeui.HybridDropdownMenuSpec

@Keep
@DoNotStrip
class HybridDropdownMenu(val context: ThemedReactContext): HybridDropdownMenuSpec() {

    // View
    override val view = DropdownMenuView(context)

    // Props
    var _selectedIndex: Int = 0
    override var selectedIndex: Double? = null
        get() = _selectedIndex.toDouble()
        set(value) {
            if (field == value) return
            _selectedIndex = value?.toInt() ?: 0
            view.selectedIndex = _selectedIndex
        }

    override var options: Array<String> = arrayOf()
        set(value) {
            if (field == value) return
            field = value
            view.options.clear()
            view.options.addAll(value)
        }

    override var onOptionSelected: ((index: Double) -> Unit)? = null
        set(value) {
            if (field == value) return
            field = value
            view.onOptionSelected = value
        }

    override var label: String? = null
        set(value) {
            if (field == value) return
            field = value
            view.label = value
        }
}