// swift-tools-version: 6.3
import PackageDescription

let package = Package(
    name: "Details",
    platforms: [.iOS(.v26)],
    products: [
        .library(
            name: "Details",
            targets: ["Details"]
        ),
    ],
    targets: [
        .target(
            name: "Details"
        ),

    ],
    swiftLanguageModes: [.v6]
)
