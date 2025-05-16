import React from 'react'
import { getHostComponent, type HybridRef } from 'react-native-nitro-modules'
import BottomSheetConfig from '../../../nitrogen/generated/shared/json/BottomSheetConfig.json'
import type {
  NitroBottomSheetProps,
  BottomSheetMethods,
  ContainerMethods,
  NitroContainerProps,
} from './bottom-sheet.nitro'
import ContainerConfig from '../../../nitrogen/generated/shared/json/ContainerConfig.json'
import type { StyleProp, ViewStyle } from 'react-native'

const NitroBottomSheet = getHostComponent<
  NitroBottomSheetProps,
  BottomSheetMethods
>('BottomSheet', () => BottomSheetConfig)

export interface BottomSheetProps extends NitroBottomSheetProps {
  style?: StyleProp<ViewStyle>
  children?: React.ReactNode
}

export function BottomSheet({ style, children, ...props }: BottomSheetProps) {
  return (
    <NitroBottomSheet collapsable={false} {...props} style={style}>
      {children}
    </NitroBottomSheet>
  )
}

export type BottomSheetRef = HybridRef<
  NitroBottomSheetProps,
  BottomSheetMethods
>

const NitroContainer = getHostComponent<NitroContainerProps, ContainerMethods>(
  'Container',
  () => ContainerConfig
)

export interface ContainerProps extends NitroContainerProps {
  style?: StyleProp<ViewStyle>
  children?: React.ReactNode
}

export function Container({ style, children, ...props }: ContainerProps) {
  return (
    <NitroContainer {...props} style={style}>
      {children}
    </NitroContainer>
  )
}

export type ContainerRef = HybridRef<ContainerProps, ContainerMethods>
