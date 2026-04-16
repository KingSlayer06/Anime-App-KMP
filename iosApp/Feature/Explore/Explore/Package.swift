// swift-tools-version: 6.3
import PackageDescription

let package = Package(
    name: "Explore",
    platforms: [.iOS(.v26)],
    products: [
        .library(
            name: "Explore",
            targets: ["Explore"]
        ),
    ],
    dependencies: [
        .package(path: "../Core/Ui/Ui"),
    ],
    targets: [
        .target(
            name: "Explore",
            dependencies: [
                "Ui"
            ]
        ),
    ],
    swiftLanguageModes: [.v6]
)
