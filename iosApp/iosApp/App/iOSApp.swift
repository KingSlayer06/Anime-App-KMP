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
    @StateObject private var navHostController = NavHostController { route in
        switch route {
            case .home: return AnyView(MainView())
            case .details(let id): return AnyView(DetailsView(id: id))
        }
    }
    
    var body: some View {
        NavigationStack(path: $navHostController.path) {
            MainView()
                .navigationDestination(for: Destination.self) { route in
                    navHostController.navigate(route: route)
                }
        }
    }
}
