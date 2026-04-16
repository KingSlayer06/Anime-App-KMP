//
//  AppTypography.swift
//  iosApp
//
//  Created by Himanshu Sherkar on 15/04/26.
//

import SwiftUI

public extension SwiftUI.Font {
    static func inter(size: CGFloat, weight: InterFontWeight = .regular) -> SwiftUI.Font {
        weight.convertible.swiftUIFont(size: size)
    }
}

public extension UIFont {
    static func inter(size: CGFloat, weight: InterFontWeight = .regular) -> UIFont {
        weight.convertible.font(size: size)
    }
}

public enum InterFontWeight {
    case regular, medium, bold
    fileprivate var convertible: FontConvertible {
        switch self {
            case .regular: FontFamily.Inter28pt.regular
            case .medium: FontFamily.Inter28pt.medium
            case .bold: FontFamily.Inter28pt.bold
        }
    }
}
