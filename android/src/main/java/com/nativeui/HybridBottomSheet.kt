package com.nativeui

import android.view.ViewGroup
import android.widget.FrameLayout
import com.facebook.react.uimanager.ThemedReactContext
import com.margelo.nitro.nativeui.HybridBottomSheetSpec

class HybridBottomSheet(val context: ThemedReactContext) : HybridBottomSheetSpec() {
    override val view = BottomSheetView(context)
}

//class HybridBottomSheet(val context: ThemedReactContext) : HybridBottomSheetSpec() {
//    override val view = BottomSheetView(context)
//}