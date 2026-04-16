import SwiftUI
import Shared
import Navigation
import Ui
import Details

@main
struct iOSApp: App {
    init() {
        AppModuleKt.doInitKoin()
    }

    var body: some Scene {
        WindowGroup {
            RootView()
        }
    }
}

struct RootView: View {
    @StateObject private var navHostController = NavHostController()
    
    var body: some View {
        NavigationStack(path: $navHostController.path) {
            MainView()
                .navigationDestination(for: Destination.self) { route in
                    route.navigate()
                }
                .appBackground()
        }
    }
}

extension Destination {
    @ViewBuilder
    func navigate() -> some View {
        switch self {
            case .home: MainView()
            case .details(let id): DetailsView(id: id)
        }
    }
}
