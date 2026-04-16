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
    dependencies: [
        .package(path: "../Core/Ui/Ui"),
    ],
    targets: [
        .target(
            name: "Details",
            dependencies: [
                "Ui"
            ]
        ),
    ],
    swiftLanguageModes: [.v6]
)
