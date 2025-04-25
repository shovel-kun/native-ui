package com.nativeui.views

import com.facebook.react.bridge.Arguments

class ShadowNodeProxy(val nativeView: NativeView) {
    fun setViewSize(width: Double, height: Double) {
        nativeView.stateWrapper?.updateState(Arguments.makeNativeMap(mapOf("width" to width, "height" to height)))
    }
}