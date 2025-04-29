package com.nativeui

import android.annotation.SuppressLint
import android.view.View
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.facebook.react.uimanager.ThemedReactContext
import com.nativeui.views.NativeComposeView

@SuppressLint("ViewConstructor")
class BottomSheetView(context: ThemedReactContext): NativeComposeView(context, withHostingView = true)  {
    var showBottomSheet by mutableStateOf<Boolean>(false)
    var children by mutableStateOf<List<View>>(emptyList())

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val scope = rememberCoroutineScope()
        val sheetState = rememberModalBottomSheetState()

        DynamicTheme {
            ModalBottomSheet(
                onDismissRequest = {
                    showBottomSheet = false
                },
                sheetState = sheetState,
                sheetMaxWidth = BottomSheetDefaults.SheetMaxWidth,
                containerColor = BottomSheetDefaults.ContainerColor,
                shape = BottomSheetDefaults.ExpandedShape,
                tonalElevation = 0.dp
            ) {
                children.map { child ->
                    AndroidView(
                        factory = { child },
                    )
                }
            }
        }
    }
}