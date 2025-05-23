///
/// TextInputKeyboardTypeOptions.swift
/// This file was generated by nitrogen. DO NOT MODIFY THIS FILE.
/// https://github.com/mrousavy/nitro
/// Copyright © 2025 Marc Rousavy @ Margelo
///

/**
 * Represents the JS union `TextInputKeyboardTypeOptions`, backed by a C++ enum.
 */
public typealias TextInputKeyboardTypeOptions = margelo.nitro.nativeui.TextInputKeyboardTypeOptions

public extension TextInputKeyboardTypeOptions {
  /**
   * Get a TextInputKeyboardTypeOptions for the given String value, or
   * return `nil` if the given value was invalid/unknown.
   */
  init?(fromString string: String) {
    switch string {
      case "default":
        self = .default
      case "number-pad":
        self = .numberPad
      case "decimal-pad":
        self = .decimalPad
      case "numeric":
        self = .numeric
      case "email-address":
        self = .emailAddress
      case "phone-pad":
        self = .phonePad
      case "url":
        self = .url
      case "ascii-capable":
        self = .asciiCapable
      case "numbers-and-punctuation":
        self = .numbersAndPunctuation
      case "name-phone-pad":
        self = .namePhonePad
      case "twitter":
        self = .twitter
      case "web-search":
        self = .webSearch
      case "password":
        self = .password
      case "number-password":
        self = .numberPassword
      default:
        return nil
    }
  }

  /**
   * Get the String value this TextInputKeyboardTypeOptions represents.
   */
  var stringValue: String {
    switch self {
      case .default:
        return "default"
      case .numberPad:
        return "number-pad"
      case .decimalPad:
        return "decimal-pad"
      case .numeric:
        return "numeric"
      case .emailAddress:
        return "email-address"
      case .phonePad:
        return "phone-pad"
      case .url:
        return "url"
      case .asciiCapable:
        return "ascii-capable"
      case .numbersAndPunctuation:
        return "numbers-and-punctuation"
      case .namePhonePad:
        return "name-phone-pad"
      case .twitter:
        return "twitter"
      case .webSearch:
        return "web-search"
      case .password:
        return "password"
      case .numberPassword:
        return "number-password"
    }
  }
}
