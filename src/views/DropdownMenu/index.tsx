import React from 'react'
import { getHostComponent, type HybridRef } from 'react-native-nitro-modules'
import DropdowMenuConfig from '../../../nitrogen/generated/shared/json/DropdownMenuConfig.json'
import type {
  NitroDropdownMenuProps,
  DropdownMenuMethods,
} from './dropdown-menu.nitro'
import type { StyleProp, ViewStyle } from 'react-native'

const NitroDropdownMenu = getHostComponent<
  NitroDropdownMenuProps,
  DropdownMenuMethods
>('DropdownMenu', () => DropdowMenuConfig)

export interface DropdownMenuProps extends NitroDropdownMenuProps {
  style?: StyleProp<ViewStyle>
}

export function DropdownMenu({
  style,
  onOptionSelected,
  ...props
}: DropdownMenuProps) {
  return (
    <NitroDropdownMenu
      {...props}
      style={style}
      onOptionSelected={{ f: onOptionSelected }}
    />
  )
}

export type DropdownMenuRef = HybridRef<
  NitroDropdownMenuProps,
  DropdownMenuMethods
>
