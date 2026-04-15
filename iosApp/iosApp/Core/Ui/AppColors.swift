//
//  Color.swift
//  iosApp
//
//  Created by Himanshu Sherkar on 15/04/26.
//

import Foundation
import SwiftUI

extension Color {
    static let primary: Color = Color("#FF6B35")
    static let secondary: Color = Color("#9B6FD4")
    static let background: Color = Color("#0E0B14")
    static let surface: Color = Color("#1A1625")
    static let surfaceRaised: Color = Color("#252033")
    static let textPrimary: Color = Color("#FFFFFF")
    static let textSecondary: Color = Color("#8A8599")
}

extension Color {
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
