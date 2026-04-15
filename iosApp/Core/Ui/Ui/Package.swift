// swift-tools-version: 6.3
import PackageDescription

let package = Package(
    name: "Ui",
    platforms: [.iOS(.v26)],
    products: [
        .library(
            name: "Ui",
            targets: ["Ui"]
        ),
    ],
    targets: [
        .target(
            name: "Ui",
            resources: [
                .process("Resources"),
            ]
        ),
        
    ],
    swiftLanguageModes: [.v6]
)
