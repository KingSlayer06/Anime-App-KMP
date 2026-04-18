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
        .package(url: "https://github.com/onevcat/Kingfisher.git", from: "8.0.0")
    ],
    targets: [
        .target(
            name: "Home",
            dependencies: [
                "Ui",
                "Kingfisher"
            ]
        ),
    ],
    swiftLanguageModes: [.v6]
)
