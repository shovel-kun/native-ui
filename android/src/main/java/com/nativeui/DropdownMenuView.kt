package com.nativeui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.text.input.setTextAndPlaceCursorAtEnd
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.facebook.react.uimanager.ThemedReactContext
import com.nativeui.views.AutoSizingComposable
import com.nativeui.views.Direction
import com.nativeui.views.NativeComposeView
import java.util.EnumSet

@SuppressLint("ViewConstructor")
class DropdownMenuView(context: ThemedReactContext): NativeComposeView(context, withHostingView = true )  {

    var selectedIndex by mutableIntStateOf(0)
    var options = mutableListOf<String>()
    var onOptionSelected by mutableStateOf<((index: Double) -> Unit)?>({})
    var label by mutableStateOf<String?>(null)

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        var expanded by remember { mutableStateOf(false) }
        val textFieldState = rememberTextFieldState(options[selectedIndex])

        DynamicTheme {
            AutoSizingComposable(shadowNodeProxy, axis = EnumSet.of(Direction.VERTICAL)) {
                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = { expanded = it },
                ) {
                    TextField(
                        modifier = Modifier.menuAnchor(ExposedDropdownMenuAnchorType.PrimaryNotEditable)
                            .fillMaxSize(),
                        state = textFieldState,
                        readOnly = true,
                        lineLimits = TextFieldLineLimits.SingleLine,
                        label = label?.let { { Text(it) } },
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                        colors = ExposedDropdownMenuDefaults.textFieldColors(),
                    )
                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                    ) {
                        options.forEachIndexed { index, option ->
                            DropdownMenuItem(
                                text = { Text(option, style = MaterialTheme.typography.bodyLarge) },
                                onClick = {
                                    textFieldState.setTextAndPlaceCursorAtEnd(option)
                                    expanded = false
                                    onOptionSelected?.invoke(index.toDouble())
                                },
                                contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                            )
                        }
                    }
                }
            }
        }
    }
}