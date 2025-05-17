import Foundation
import UIKit

class HybridTriStateCheckbox : HybridTriStateCheckboxSpec {
    
    // UIView
    var view: UIView = UIView()

    // Props
    var state: TriStateCheckboxState = TriStateCheckboxState.off
    
    var disabled: Bool?

    var onPress: (() -> Void)?
}
