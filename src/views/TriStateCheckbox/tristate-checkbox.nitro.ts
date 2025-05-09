import type {
  HybridView,
  HybridViewProps,
  HybridViewMethods,
} from 'react-native-nitro-modules'

export type TriStateCheckboxState = 'on' | 'off' | 'indeterminate'

export interface NitroTriStateCheckboxProps extends HybridViewProps {
  /**
   * Whether this checkbox is checked, unchecked, or in an indeterminate state
   */
  state: TriStateCheckboxState
  /**
   * Controls the disabled state of this checkbox. When `true`, this component will not
   * respond to user input, and it will appear visually disabled and disabled to accessibility
   * services.
   */
  disabled?: boolean | undefined
  /**
   * Called when this checkbox is pressed. If `null` or `undefined`, then this checkbox will not be
   * interactable, unless something else handles its input events and updates its [state]
   */
  onPress?: (() => void) | undefined
}

export interface TriStateCheckboxMethods extends HybridViewMethods {}

export type TriStateCheckbox = HybridView<
  NitroTriStateCheckboxProps,
  TriStateCheckboxMethods,
  { ios: 'swift'; android: 'kotlin' }
>
