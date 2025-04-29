package com.nativeui

import androidx.annotation.Keep
import androidx.compose.ui.text.input.KeyboardType
import com.facebook.proguard.annotations.DoNotStrip
import com.facebook.react.uimanager.ThemedReactContext
import com.margelo.nitro.nativeui.HybridTextInputSpec
import com.margelo.nitro.nativeui.TextInputKeyboardTypeOptions
import com.margelo.nitro.nativeui.TextInputVariant

@Keep
@DoNotStrip
class HybridTextInput(val context: ThemedReactContext): HybridTextInputSpec() {
    // View
    override val view = TextInputView(context)

    // Props
    override var defaultValue: String? = ""
        get() = view.defaultValue
        set(value) {
            if (field == value || value == null) return
            field = value
            view.defaultValue = value
        }

    override var onChangeText: ((String) -> Unit)? = null
        set(value) {
            if (field == value) return
            field = value
            view.onChangeText = value
        }

    override var multiline: Boolean? = null
        set(value) {
            if (field == value) return
            field = value
            view.multiline = value
        }

    override var numberOfLines: Double? = null
        set(value) {
            if (field == value) return
            field = value
            view.numberOfLines = value
        }

    override var keyboardType: TextInputKeyboardTypeOptions? = null
        set(value) {
            if (field == value || value == null) return
            field = value
            view.keyboardType = value.toComposeKeyboardType()
        }

    override var autocorrection: Boolean? = null
        set(value) {
            if (field == value) return
            field = value
            view.autocorrection = value
        }

    override var variant: TextInputVariant? = null
        set(value) {
            if (field == value) return
            field = value
            view.variant = value
        }

    override var label: String? = null
        set(value) {
            if (field == value) return
            field = value
            view.label = value
        }

    override var placeholder: String? = null
        set(value) {
            if (field == value) return
            field = value
            view.placeholder = value
        }
}

fun TextInputKeyboardTypeOptions.toComposeKeyboardType(): KeyboardType {
    return when (this) {
        TextInputKeyboardTypeOptions.DEFAULT -> KeyboardType.Text
        TextInputKeyboardTypeOptions.NUMERIC -> KeyboardType.Number
        TextInputKeyboardTypeOptions.EMAIL_ADDRESS -> KeyboardType.Email
        TextInputKeyboardTypeOptions.PHONE_PAD -> KeyboardType.Phone
        TextInputKeyboardTypeOptions.DECIMAL_PAD -> KeyboardType.Decimal
        TextInputKeyboardTypeOptions.PASSWORD -> KeyboardType.Password
        TextInputKeyboardTypeOptions.ASCII_CAPABLE -> KeyboardType.Ascii
        TextInputKeyboardTypeOptions.URL -> KeyboardType.Uri
        TextInputKeyboardTypeOptions.NUMBER_PASSWORD -> KeyboardType.NumberPassword
        else -> KeyboardType.Text
    }
}

