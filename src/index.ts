import { getHostComponent, type HybridRef } from 'react-native-nitro-modules'
import TextInputConfig from '../nitrogen/generated/shared/json/TextInputConfig.json'
import type { TextInputProps, TextInputMethods } from './views/text-input.nitro'

export const TextInput = getHostComponent<TextInputProps, TextInputMethods>(
  'TextInput',
  () => TextInputConfig
)

export type TextInputRef = HybridRef<TextInputProps, TextInputMethods>
