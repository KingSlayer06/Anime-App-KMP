// swift-tools-version: 6.3
import PackageDescription

let package = Package(
    name: "Navigation",
    platforms: [.iOS(.v26)],
    products: [
        .library(
            name: "Navigation",
            targets: ["Navigation"]
        ),
    ],
    targets: [
        .target(
            name: "Navigation",
        ),
        
    ],
    swiftLanguageModes: [.v6]
)
