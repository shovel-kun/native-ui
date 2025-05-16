package com.nativeui

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewStructure
import android.view.accessibility.AccessibilityEvent
import android.widget.LinearLayout
import com.facebook.react.bridge.LifecycleEventListener
import com.facebook.react.bridge.UiThreadUtil
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.events.EventDispatcher
import com.facebook.react.views.view.ReactViewGroup


@SuppressLint("ViewConstructor")
class RootBottomSheetView(context: ThemedReactContext) :
    ReactViewGroup(context),
    LifecycleEventListener {

    var eventDispatcher: EventDispatcher?
        get() = rootSheetView.eventDispatcher
        set(eventDispatcher) {
            rootSheetView.eventDispatcher = eventDispatcher
        }


//    var hybridView: HybridBottomSheet

    /**
     * The main BottomSheetDialog instance.
     */

    /**
     * React root view placeholder.
     */
    private val rootSheetView: RootSheetView

    init {
        context.addLifecycleEventListener(this)

        rootSheetView = RootSheetView(context)
//        hybridView = HybridBottomSheet(reactContext, rootSheetView)
//        hybridView = HybridBottomSheet(context)
//        viewTreeObserver.addOnGlobalLayoutListener { requestLayout() }
    }

    override fun dispatchProvideStructure(structure: ViewStructure) {
        rootSheetView.dispatchProvideStructure(structure)
    }

    override fun onLayout(
        changed: Boolean,
        l: Int,
        t: Int,
        r: Int,
        b: Int
    ) {
        // Do nothing as we are laid out by UIManager
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        onDropInstance()
    }

    override fun addView(child: View, index: Int) {
        UiThreadUtil.assertOnUiThread()
        rootSheetView.addView(child, index)
        Log.i("BottomSheetView", "addView called")

        // Hide this host view
        visibility = GONE
    }

    override fun getChildCount(): Int {
        // This method may be called by the parent constructor
        // before rootView is initialized.
        return rootSheetView.childCount
    }

    override fun getChildAt(index: Int): View = rootSheetView.getChildAt(index)

    override fun removeView(child: View) {
        UiThreadUtil.assertOnUiThread()
        rootSheetView.removeView(child)
    }

    override fun removeViewAt(index: Int) {
        UiThreadUtil.assertOnUiThread()
        val child = getChildAt(index)
        rootSheetView.removeView(child)
    }

    override fun addChildrenForAccessibility(outChildren: ArrayList<View>) {
        // Explicitly override this to prevent accessibility events being passed down to children
        // Those will be handled by the rootView which lives in the dialog
    }

    // Explicitly override this to prevent accessibility events being passed down to children
    // Those will be handled by the mHostView which lives in the dialog
    override fun dispatchPopulateAccessibilityEvent(event: AccessibilityEvent): Boolean = false

    override fun onHostResume() {
    }

    override fun onHostPause() {
        // do nothing
    }

    override fun onHostDestroy() {
        // Drop the instance if the host is destroyed which will dismiss the dialog
        onDropInstance()
    }

    fun onDropInstance() {
        (context as ThemedReactContext).removeLifecycleEventListener(this)
    }
}

class NativeLinearLayout(context: Context?) : LinearLayout(context)
