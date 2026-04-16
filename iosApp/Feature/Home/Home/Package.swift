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
    dependencies: [
        .package(path: "../Core/Ui/Ui"),
    ],
    targets: [
        .target(
            name: "Home",
            dependencies: [
                "Ui"
            ]
        ),
    ],
    swiftLanguageModes: [.v6]
)
