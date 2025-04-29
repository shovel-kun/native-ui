import type {
  HybridView,
  HybridViewProps,
  HybridViewMethods,
} from 'react-native-nitro-modules'

export interface DropdownMenuProps extends HybridViewProps {
  label?: string | undefined
  selectedIndex?: number | undefined
  onOptionSelected?: ((index: number) => void) | undefined
  options: string[]
}

export interface DropdownMenuMethods extends HybridViewMethods {}

export type DropdownMenu = HybridView<
  DropdownMenuProps,
  DropdownMenuMethods,
  { ios: 'swift'; android: 'kotlin' }
>
