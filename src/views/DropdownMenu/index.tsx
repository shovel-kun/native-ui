import { getHostComponent, type HybridRef } from 'react-native-nitro-modules'
import DropdowMenuConfig from '../../../nitrogen/generated/shared/json/DropdownMenuConfig.json'
import type {
  DropdownMenuProps,
  DropdownMenuMethods,
} from './dropdown-menu.nitro'

export const DropdownMenu = getHostComponent<
  DropdownMenuProps,
  DropdownMenuMethods
>('DropdownMenu', () => DropdowMenuConfig)

export type DropdownMenuRef = HybridRef<DropdownMenuProps, DropdownMenuMethods>
