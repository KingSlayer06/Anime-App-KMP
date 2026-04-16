// swift-tools-version: 6.3
import PackageDescription

let package = Package(
    name: "Ui",
    platforms: [.iOS(.v26)],
    products: [
        .library(
            name: "Ui",
            targets: ["Ui"]
        ),
    ],
    dependencies: [
        .package(url: "https://github.com/SwiftGen/SwiftGenPlugin", from: "6.6.0")
    ],
    targets: [
        .target(
            name: "Ui",
            resources: [
                .process("Resources/Fonts/"),
                .process("Resources/Images.xcassets"),
                .process("Resources/Colors.xcassets"),
            ],
            plugins: [
                .plugin(name: "SwiftGenPlugin", package: "SwiftGenPlugin")
            ]
        ),
    ],
    swiftLanguageModes: [.v6]
)
