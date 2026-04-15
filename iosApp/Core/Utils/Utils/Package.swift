// swift-tools-version: 6.3
import PackageDescription

let package = Package(
    name: "Utils",
    platforms: [.iOS(.v26)],
    products: [
        .library(
            name: "Utils",
            targets: ["Utils"]
        ),
    ],
    targets: [
        .target(
            name: "Utils"
        ),

    ],
    swiftLanguageModes: [.v6]
)
