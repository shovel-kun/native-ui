import type {
  HybridView,
  HybridViewProps,
  HybridViewMethods,
} from 'react-native-nitro-modules'

export interface TextInputProps extends HybridViewProps {
  value?: string
  onValueChange?: (value: string) => void
  placeholder?: string
  label?: string
}

export interface TextInputMethods extends HybridViewMethods {}

export type TextInput = HybridView<
  TextInputProps,
  TextInputMethods,
  { ios: 'swift'; android: 'kotlin' }
>
