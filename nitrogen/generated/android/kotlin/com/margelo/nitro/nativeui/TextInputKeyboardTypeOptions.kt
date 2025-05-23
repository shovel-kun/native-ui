///
/// TextInputKeyboardTypeOptions.kt
/// This file was generated by nitrogen. DO NOT MODIFY THIS FILE.
/// https://github.com/mrousavy/nitro
/// Copyright © 2025 Marc Rousavy @ Margelo
///

package com.margelo.nitro.nativeui

import androidx.annotation.Keep
import com.facebook.proguard.annotations.DoNotStrip

/**
 * Represents the JavaScript enum/union "TextInputKeyboardTypeOptions".
 */
@DoNotStrip
@Keep
enum class TextInputKeyboardTypeOptions {
  DEFAULT,
  NUMBER_PAD,
  DECIMAL_PAD,
  NUMERIC,
  EMAIL_ADDRESS,
  PHONE_PAD,
  URL,
  ASCII_CAPABLE,
  NUMBERS_AND_PUNCTUATION,
  NAME_PHONE_PAD,
  TWITTER,
  WEB_SEARCH,
  PASSWORD,
  NUMBER_PASSWORD;

  @DoNotStrip
  @Keep
  private val _ordinal = ordinal
}
