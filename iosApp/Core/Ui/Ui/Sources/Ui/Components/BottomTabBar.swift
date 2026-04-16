//
//  File.swift
//  Ui
//
//  Created by Himanshu Sherkar on 16/04/26.
//

import SwiftUI

private enum NavigationItem: Int, Identifiable {
    case home
    case explore
    case myLibrary
    
    var id: Int { return self.rawValue }
    
    var label: String {
        switch self {
            case .home:
                "Home"
            case .explore:
                "Explore"
            case .myLibrary:
                "My Library"
        }
    }
    
    var icon: Image {
        switch self {
            case .home:
                Image(systemName: "house.fill")
            case .explore:
                Image(systemName: "binoculars.fill")
            case .myLibrary:
                Image(systemName: "books.vertical.fill")
        }
    }
}

public struct BottomTabBar: View {
    @Binding public var selectedRoute: Int?
    
    public var onSelected: (Int) -> Void
    
    public init(
        selectedRoute: Binding<Int?> = .constant(nil),
        onSelected: @escaping (Int) -> Void
    ) {
        self._selectedRoute = selectedRoute
        self.onSelected = onSelected
    }
    
    fileprivate let navigationItems: [NavigationItem] = [
        .home,
        .explore,
        .myLibrary
    ]
    
    public var body: some View {
        ZStack {
            HStack {
                Spacer()
                
                ForEach(navigationItems, id: \.id) { item in
                    let isSelected = selectedRoute == item.id
                    
                    VStack(spacing: 5) {
                        item.icon
                            .foregroundStyle(Color.textPrimary)
                            .opacity(isSelected ? 1 : 0.5)
                        
                        Text(item.label)
                            .font(.inter(size: 15))
                            .foregroundStyle(Color.textPrimary)
                            .opacity(isSelected ? 1 : 0.5)
                    }
                    .contentShape(Rectangle())
                    .onTapGesture {
                        onSelected(item.id)
                    }
                    
                    Spacer()
                }
            }

        }
        .frame(maxWidth: .infinity, maxHeight: 108)
        .background(Color.background)
        .clipShape(UnevenRoundedRectangle(topLeadingRadius: 20, topTrailingRadius: 20))
    }
}

#Preview {
    @Previewable 
    @State var selectedRoute: Int? = 0
    
    BottomTabBar(selectedRoute: $selectedRoute) { route in
        selectedRoute = route
    }
}
