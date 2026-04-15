//
//  AppTypography.swift
//  iosApp
//
//  Created by Himanshu Sherkar on 15/04/26.
//

import SwiftUI

public extension Font {
    static func inter(size: CGFloat, weight: FontWeight = .regular) -> Font {
        return Font.custom(weight.rawValue, size: size)
    }
}

public extension UIFont {
    static func inter(size: CGFloat, weight: FontWeight = .regular) -> UIFont? {
        return UIFont(name: weight.rawValue, size: size)
    }
}

public enum FontProvider {
    public static func provideInterFont() {
        let bundle = Bundle.module
        ["Inter-Regular.ttf", "Inter-Medium.ttf", "Inter-Bold.ttf"].forEach { name in
            guard let url = bundle.url(forResource: name, withExtension: nil) else { return }
            CTFontManagerRegisterFontsForURL(url as CFURL, .process, nil)
        }
    }
}

public enum FontWeight: String {
    case regular = "Inter-Regular"
    case medium = "Inter-Medium"
    case bold = "Inter-Bold"
}

extension View {
    // Attach this to Preview for custom font
    public func loadCustomFonts() -> some View {
        FontProvider.provideInterFont()
        return self
    }
}
