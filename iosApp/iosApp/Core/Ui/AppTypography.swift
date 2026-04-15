//
//  AppTypography.swift
//  iosApp
//
//  Created by Himanshu Sherkar on 15/04/26.
//

import SwiftUI

extension Font {
    static func interFont(size: CGFloat, fontWeight: CustomFont = .regular) -> Font {
        return Font.custom(fontWeight.rawValue, size: size)
    }
}

extension UIFont {
    static func interFont(size: CGFloat, fontWeight: CustomFont) -> UIFont? {
        return UIFont(name: fontWeight.rawValue, size: size)
    }
}

enum CustomFont: String {
    case regular = "inter_regular"
    case medium = "inter_medium"
    case bold = "inter_bold"
}
