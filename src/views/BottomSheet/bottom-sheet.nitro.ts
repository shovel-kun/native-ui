import type {
  HybridView,
  HybridViewProps,
  HybridViewMethods,
} from 'react-native-nitro-modules'

export interface NitroBottomSheetProps extends HybridViewProps {}

export interface BottomSheetMethods extends HybridViewMethods {}

export type BottomSheet = HybridView<
  NitroBottomSheetProps,
  BottomSheetMethods,
  { ios: 'swift'; android: 'kotlin' }
>

export interface NitroContainerProps extends HybridViewProps {}

export interface ContainerMethods extends HybridViewMethods {}

export type Container = HybridView<
  NitroContainerProps,
  ContainerMethods,
  { ios: 'swift'; android: 'kotlin' }
>
