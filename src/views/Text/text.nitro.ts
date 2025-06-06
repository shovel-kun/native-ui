import type {
  HybridView,
  HybridViewProps,
  HybridViewMethods,
} from 'react-native-nitro-modules'

export interface TextProps extends HybridViewProps {
  text?: string
}

export interface TextMethods extends HybridViewMethods {}

export type NitroText = HybridView<
  TextProps,
  TextMethods,
  { ios: 'swift'; android: 'kotlin' }
>
