import type {
  HybridView,
  HybridViewProps,
  HybridViewMethods,
} from 'react-native-nitro-modules'

export interface DropdownMenuProps extends HybridViewProps {
  label?: string
  selectedIndex?: number
  onOptionSelected?: (index: number) => void
  options: string[]
}

export interface DropdownMenuMethods extends HybridViewMethods {}

export type DropdownMenu = HybridView<
  DropdownMenuProps,
  DropdownMenuMethods,
  { ios: 'swift'; android: 'kotlin' }
>
