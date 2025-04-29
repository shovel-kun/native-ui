import { getHostComponent, type HybridRef } from 'react-native-nitro-modules'
import TriStateCheckboxConfig from '../../../nitrogen/generated/shared/json/TriStateCheckboxConfig.json'
import type {
  TriStateCheckboxProps,
  TriStateCheckboxMethods,
} from './tristate-checkbox.nitro'

export const TriStateCheckbox = getHostComponent<
  TriStateCheckboxProps,
  TriStateCheckboxMethods
>('TriStateCheckbox', () => TriStateCheckboxConfig)

export type TriStateCheckboxRef = HybridRef<
  TriStateCheckboxProps,
  TriStateCheckboxMethods
>

export type { TriStateCheckboxState } from './tristate-checkbox.nitro'
