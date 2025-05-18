import Foundation
import UIKit

class HybridTextInput : HybridTextInputSpec {
    // UIView
    var view: UIView = UIView()

    // Props
    var defaultValue: String?
    
    var onChangeText: ((String) -> Void)?
    
    var multiline: Bool?
    
    var numberOfLines: Double?
    
    var keyboardType: TextInputKeyboardTypeOptions?
    
    var autocorrection: Bool?
    
    var variant: TextInputVariant?
    
    var placeholder: String?
    
    var label: String?
}
