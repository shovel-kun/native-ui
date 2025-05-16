import React from 'react'
import { getHostComponent, type HybridRef } from 'react-native-nitro-modules'
import TriStateCheckboxConfig from '../../../nitrogen/generated/shared/json/TriStateCheckboxConfig.json'
import type {
  NitroTriStateCheckboxProps,
  TriStateCheckboxMethods,
} from './tristate-checkbox.nitro'
import type { StyleProp, ViewStyle } from 'react-native'

const NitroTriStateCheckbox = getHostComponent<
  NitroTriStateCheckboxProps,
  TriStateCheckboxMethods
>('TriStateCheckbox', () => TriStateCheckboxConfig)

export interface TriStateCheckboxProps extends NitroTriStateCheckboxProps {
  style?: StyleProp<ViewStyle>
}

export function TriStateCheckbox({
  style,
  onPress,
  ...props
}: TriStateCheckboxProps) {
  return (
    <NitroTriStateCheckbox {...props} style={style} onPress={{ f: onPress }} />
  )
}

export type TriStateCheckboxRef = HybridRef<
  NitroTriStateCheckboxProps,
  TriStateCheckboxMethods
>

export type { TriStateCheckboxState } from './tristate-checkbox.nitro'
