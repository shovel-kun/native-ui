import type {
  HybridView,
  HybridViewProps,
  HybridViewMethods,
} from 'react-native-nitro-modules'

export type KeyboardType =
  | 'default'
  | 'number-pad'
  | 'decimal-pad'
  | 'numeric'
  | 'email-address'
  | 'phone-pad'
  | 'url'
export type KeyboardTypeIOS =
  | 'ascii-capable'
  | 'numbers-and-punctuation'
  | 'name-phone-pad'
  | 'twitter'
  | 'web-search'
export type KeyboardTypeAndroid = 'password' | 'number-password'
export type TextInputKeyboardTypeOptions =
  | KeyboardType
  | KeyboardTypeAndroid
  | KeyboardTypeIOS
export type TextInputVariant = 'outlined' | 'filled' | 'basic'

export interface TextInputProps extends HybridViewProps {
  /**
   * Initial value that the TextInput displays when being mounted. As the TextInput is an uncontrolled component, change the key prop if you need to change the text value.
   */
  defaultValue?: string | undefined
  /**
   * Callback that is called when the text input's text changes.
   * Changed text is passed as an argument to the callback handler.
   */
  onChangeText?: ((text: string) => void) | undefined
  /**
   * If true, the text input can be multiple lines.
   * While the content will wrap, there's no keyboard button to insert a new line.
   */
  multiline?: boolean | undefined
  /**
   * The number of lines to display when `multiline` is set to true.
   * If the number of lines in the view is above this number, the view scrolls.
   * @default undefined, which means unlimited lines.
   */
  numberOfLines?: number | undefined
  /**
   * Determines which keyboard to open. For example, `'numeric'`.
   *
   * Types that work on both platforms:
   * - default
   * - numeric
   * - email-address
   * - phone-pad
   * - decimal-pad
   * - ascii-capable
   * - url
   *
   * Types that only work on Android:
   * - password
   * - number-password
   *
   * Types that only work on iOS:
   * - numbers-and-punctuation
   * - name-phone-pad
   * - twitter
   * - web-search
   * - ascii-capable-number-pad
   *
   * @default default
   */
  keyboardType?: TextInputKeyboardTypeOptions | undefined
  /**
   * If true, autocorrection is enabled.
   * @default true
   */
  autocorrection?: boolean | undefined
  variant?: TextInputVariant | undefined
  /**
   * The string that will be rendered before text input has been entered
   */
  placeholder?: string | undefined
  label?: string | undefined
}

export interface TextInputMethods extends HybridViewMethods {}

export type TextInput = HybridView<
  TextInputProps,
  TextInputMethods,
  { ios: 'swift'; android: 'kotlin' }
>
