// swift-tools-version: 6.3
import PackageDescription

let package = Package(
    name: "MyLibrary",
    platforms: [.iOS(.v26)],
    products: [
        .library(
            name: "MyLibrary",
            targets: ["MyLibrary"]
        ),
    ],
    dependencies: [
        .package(path: "../Core/Ui/Ui"),
    ],
    targets: [
        .target(
            name: "MyLibrary",
            dependencies: [
                "Ui"
            ]
        ),
    ],
    swiftLanguageModes: [.v6]
)
