package com.nativeui

import android.annotation.SuppressLint
import android.content.Context
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.facebook.react.uimanager.ThemedReactContext
import com.nativeui.views.NativeComposeView

@SuppressLint("ViewConstructor")
class BottomSheetView(context: ThemedReactContext): NativeComposeView(context, withHostingView = true)  {
    var showBottomSheet by mutableStateOf<Boolean>(true)

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val scope = rememberCoroutineScope()
        val sheetState = rememberModalBottomSheetState(
            skipPartiallyExpanded = true,
        )

        if (showBottomSheet) {
            DynamicTheme {
                ModalBottomSheet(
                    onDismissRequest = {
                        showBottomSheet = false
                    },
                    sheetState = sheetState,
                    //modifier = Modifier.fillMaxHeight()
                ) {
                    LazyColumn {
                        items(childCount) { index ->
                            val child = getChildAt(index) as? NativeComposeView ?: return@items
                            child.Content()
                        }
                    }
                }
            }
        }
    }
}

class ContainerView(context: Context) : NativeComposeView(context, withHostingView = true) {
    @Composable
    override fun Content() {
        for (index in 0 until childCount) {
            val child = getChildAt(index) as? NativeComposeView?: continue
            child.Content()
        }
    }
}