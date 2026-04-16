//
//  Color.swift
//  iosApp
//
//  Created by Himanshu Sherkar on 15/04/26.
//

import Foundation
import SwiftUI

public extension Color {
    static let themePrimary: Color = Asset.Colors.primary.swiftUIColor
    static let themeSecondary: Color = Asset.Colors.secondary.swiftUIColor
    static let background: Color = Asset.Colors.background.swiftUIColor
    static let surface: Color = Asset.Colors.surface.swiftUIColor
    static let surfaceRaised: Color = Asset.Colors.surfaceRaised.swiftUIColor
    static let textPrimary: Color = Asset.Colors.textPrimary.swiftUIColor
    static let textSecondary: Color = Asset.Colors.textSecondary.swiftUIColor
}

public extension Color {
    init(hex: String) {
        let scanner = Scanner(string: hex)
        _ = scanner.scanString("#")
        
        var rgb: UInt64 = 0
        scanner.scanHexInt64(&rgb)
        
        let red = Double((rgb >> 16) & 0xFF) / 255.0
        let green = Double((rgb >> 8) & 0xFF) / 255.0
        let blue = Double(rgb & 0xFF) / 255.0
        
        self.init(red: red, green: green, blue: blue)
    }
}
