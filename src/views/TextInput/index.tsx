import React from 'react'
import { getHostComponent, type HybridRef } from 'react-native-nitro-modules'
import TextInputConfig from '../../../nitrogen/generated/shared/json/TextInputConfig.json'
import type { NitroTextInputProps, TextInputMethods } from './text-input.nitro'
import type { StyleProp, ViewStyle } from 'react-native'

const NitroTextInput = getHostComponent<NitroTextInputProps, TextInputMethods>(
  'TextInput',
  () => TextInputConfig
)

export interface TextInputProps extends NitroTextInputProps {
  style?: StyleProp<ViewStyle>
}

export function TextInput({ style, onChangeText, ...props }: TextInputProps) {
  return (
    <NitroTextInput
      {...props}
      style={style}
      onChangeText={{ f: onChangeText }}
    />
  )
}

export type TextInputRef = HybridRef<NitroTextInputProps, TextInputMethods>

export type {
  KeyboardType,
  KeyboardTypeAndroid,
  KeyboardTypeIOS,
  TextInputKeyboardTypeOptions,
  TextInputVariant,
} from './text-input.nitro'
