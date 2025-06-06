// import React from 'react'
import { getHostComponent, type HybridRef } from 'react-native-nitro-modules'
import NitroTextConfig from '../../../nitrogen/generated/shared/json/NitroTextConfig.json'
import type {
  TextProps as NitroTextProps,
  TextMethods as NitroTextMethods,
} from './text.nitro'

export const NitroText = getHostComponent<NitroTextProps, NitroTextMethods>(
  'NitroText',
  () => NitroTextConfig
)

export type TextRef = HybridRef<NitroTextProps, NitroTextMethods>

export type TextProps = NitroTextProps & {
  children?: string
}

// export function Text({ children, ...props }: TextProps) {
//   console.log(children)
//   return <NitroText {...props} text={children} />
// }
