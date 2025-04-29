package com.nativeui

import android.annotation.SuppressLint
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import com.facebook.react.uimanager.ThemedReactContext
import com.margelo.nitro.nativeui.TextInputVariant
import com.nativeui.views.AutoSizingComposable
import com.nativeui.views.Direction
import com.nativeui.views.NativeComposeView
import java.util.EnumSet

@SuppressLint("ViewConstructor")
class TextInputView(context: ThemedReactContext) : NativeComposeView(context, withHostingView = true) {
    var defaultValue by mutableStateOf("")
    var onChangeText by mutableStateOf<((String) -> Unit)?>(null)
    var multiline by mutableStateOf<Boolean?>(null)
    var numberOfLines by mutableStateOf<Double?>(null)
    var keyboardType by mutableStateOf<KeyboardType>(KeyboardType.Text)
    var autocorrection by mutableStateOf<Boolean?>(null)
    var variant by mutableStateOf<TextInputVariant?>(null)
    var label by mutableStateOf<String?>(null)
    var placeholder by mutableStateOf<String?>(null)

    @Composable
    override fun Content() {
        AutoSizingComposable(
            shadowNodeProxy,
            axis = EnumSet.of(Direction.VERTICAL)
        ) {
            DynamicTheme {
                when (variant) {
                    TextInputVariant.OUTLINED -> renderOutlinedTextField()
                    TextInputVariant.FILLED -> renderFilledTextField()
                    TextInputVariant.BASIC -> renderBasicTextField()
                    else -> renderDefaultTextField()
                }
            }
        }
    }

    @Composable
    private fun renderCommonTextFieldProps(): TextFieldConfig {
        return TextFieldConfig(
            value = defaultValue,
            onValueChange = { newValue ->
                defaultValue = newValue
                onChangeText?.invoke(newValue)
            },
            placeholder = placeholder,
            label = label,
            keyboardOptions = createKeyboardOptions()
        )
    }

    @Composable
    private fun renderOutlinedTextField() {
        val config = renderCommonTextFieldProps()
        OutlinedTextField(
            value = config.value,
            onValueChange = config.onValueChange,
            placeholder = config.placeholder?.let { { Text(it) } },
            label = config.label?.let { { Text(it) } },
            keyboardOptions = config.keyboardOptions
        )
    }

    @Composable
    private fun renderFilledTextField() {
        val config = renderCommonTextFieldProps()
        TextField(
            value = config.value,
            onValueChange = config.onValueChange,
            placeholder = config.placeholder?.let { { Text(it) } },
            label = config.label?.let { { Text(it) } },
            keyboardOptions = config.keyboardOptions
        )
    }

    @Composable
    private fun renderBasicTextField() {
        BasicTextField(
            value = defaultValue,
            onValueChange = { newValue ->
                defaultValue = newValue
                onChangeText?.invoke(newValue)
            },
            keyboardOptions = createKeyboardOptions()
        )
    }

    @Composable
    private fun renderDefaultTextField() {
        val config = renderCommonTextFieldProps()
        TextField(
            value = config.value,
            onValueChange = config.onValueChange,
            placeholder = config.placeholder?.let { { Text(it) } },
            label = config.label?.let { { Text(it) } },
            keyboardOptions = config.keyboardOptions
        )
    }

    private fun createKeyboardOptions(): KeyboardOptions {
        return KeyboardOptions.Default.copy(
            keyboardType = keyboardType,
            autoCorrectEnabled = autocorrection
        )
    }
}

private data class TextFieldConfig(
    val value: String,
    val onValueChange: (String) -> Unit,
    val placeholder: String?,
    val label: String?,
    val keyboardOptions: KeyboardOptions
)