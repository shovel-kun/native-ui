import Foundation
import UIKit

class HybridDropdownMenu : HybridDropdownMenuSpec {
    // UIView
    var view: UIView = UIView()

    // Props
    var label: String?
    
    var selectedIndex: Double?
    
    var onOptionSelected: ((Double) -> Void)?
    
    var options: [String] = []
}
