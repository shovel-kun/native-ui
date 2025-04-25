import { getHostComponent, type HybridRef } from 'react-native-nitro-modules'
import NativeUiConfig from '../nitrogen/generated/shared/json/NativeUiConfig.json'
import type {
  NativeUiProps,
  NativeUiMethods,
} from './views/native-ui.nitro'


export const NativeUi = getHostComponent<NativeUiProps, NativeUiMethods>(
  'NativeUi',
  () => NativeUiConfig
)

export type NativeUiRef = HybridRef<NativeUiProps, NativeUiMethods>
