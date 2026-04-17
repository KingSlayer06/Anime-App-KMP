//
//  MainView.swift
//  iosApp
//
//  Created by Himanshu Sherkar on 15/04/26.
//

import SwiftUI
import Ui
import Home
import Explore
import MyLibrary

struct MainView: View {
    @State var selectedRoute: Int? = 0
    
    var onClick: (Int32) -> Void
    
    var body: some View {
        VStack {
            TabView(selection: $selectedRoute) {
                switch selectedRoute {
                    case 0: HomeView(onClick: onClick)
                            .appBackground()
                        
                    case 1: ExploreView()
                            .appBackground()
                        
                    case 2: MyLibrary()
                            .appBackground()
                        
                    default: EmptyView()
                }
            }
            
            BottomTabBar(selectedRoute: $selectedRoute) { route in
                selectedRoute = route
            }
        }
    }
}

#Preview {
    MainView() { _ in }
}
