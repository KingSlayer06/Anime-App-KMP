// swift-tools-version: 6.3
import PackageDescription

let package = Package(
    name: "Home",
    platforms: [.iOS(.v26)],
    products: [
        .library(
            name: "Home",
            targets: ["Home"]
        ),
    ],
    targets: [
        .target(
            name: "Home"
        ),
        
    ],
    swiftLanguageModes: [.v6]
)
