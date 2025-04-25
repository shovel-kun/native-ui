import type {
  HybridView,
  HybridViewProps,
  HybridViewMethods,
} from 'react-native-nitro-modules'

export interface TextInputProps extends HybridViewProps {
  isRed: boolean
}

export interface TextInputMethods extends HybridViewMethods {}

export type TextInput = HybridView<
  TextInputProps,
  TextInputMethods,
  { ios: 'swift'; android: 'kotlin' }
>
