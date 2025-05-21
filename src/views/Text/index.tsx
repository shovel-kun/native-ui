import React from 'react'
import { getHostComponent, type HybridRef } from 'react-native-nitro-modules'
import TextConfig from '../../../nitrogen/generated/shared/json/TextConfig.json'
import type {
  TextProps as NitroTextProps,
  TextMethods as NitroTextMethods,
} from './text.nitro'

export const Text = getHostComponent<NitroTextProps, NitroTextMethods>(
  'Text',
  () => TextConfig
)

export type TextRef = HybridRef<NitroTextProps, NitroTextMethods>

export type TextProps = NitroTextProps & {
  children?: string
}

// export function Text({ children, ...props }: TextProps) {
//   console.log(children)
//   return <NitroText {...props} text={children} />
// }
