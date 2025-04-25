import { getHostComponent, type HybridRef } from 'react-native-nitro-modules'
import TextInputConfig from '../nitrogen/generated/shared/json/TextInputConfig.json'
import type { TextInputProps, TextInputMethods } from './views/text-input.nitro'
import DropdowMenuConfig from '../nitrogen/generated/shared/json/DropdownMenuConfig.json'
import type {
  DropdownMenuProps,
  DropdownMenuMethods,
} from './views/dropdown-menu.nitro'

export const TextInput = getHostComponent<TextInputProps, TextInputMethods>(
  'TextInput',
  () => TextInputConfig
)

export type TextInputRef = HybridRef<TextInputProps, TextInputMethods>

export const DropdownMenu = getHostComponent<
  DropdownMenuProps,
  DropdownMenuMethods
>('DropdownMenu', () => DropdowMenuConfig)
