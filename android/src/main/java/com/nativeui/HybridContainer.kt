package com.nativeui

import com.facebook.react.uimanager.ThemedReactContext
import com.margelo.nitro.nativeui.HybridContainerSpec

class HybridContainer(val context: ThemedReactContext) : HybridContainerSpec() {
    override val view = ContainerView(context)
}