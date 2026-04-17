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
            MainView(onClick: { id in
                navHostController.navigate(route: .details(id: id))
            })
            .navigationDestination(for: Destination.self) { route in
                route.setPath(navHostController)
            }
            .appBackground()
        }
    }
}

extension Destination {
    @ViewBuilder
    func setPath(_ navHostController: NavHostController) -> some View {
        switch self {
            case .home: MainView() { id in
                navHostController.navigate(route: .details(id: id))
            }
                
            case .details(let id): DetailsView(id: id)
        }
    }
}
