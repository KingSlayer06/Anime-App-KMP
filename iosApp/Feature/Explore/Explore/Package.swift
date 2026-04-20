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
        .package(url: "https://github.com/onevcat/Kingfisher.git", from: "8.0.0")
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
