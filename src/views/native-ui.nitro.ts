import type {
  HybridView,
  HybridViewProps,
  HybridViewMethods,
} from 'react-native-nitro-modules'

export interface NativeUiProps extends HybridViewProps {
   isRed: boolean
}

export interface NativeUiMethods extends HybridViewMethods {}

export type NativeUi = HybridView<NativeUiProps, NativeUiMethods, { ios: 'swift', android: 'kotlin' }>