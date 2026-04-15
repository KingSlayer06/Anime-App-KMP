//
//  File.swift
//  Navigation
//
//  Created by Himanshu Sherkar on 15/04/26.
//

import SwiftUI

public final class NavHostController: ObservableObject {
    @Published public var path = NavigationPath()
    
    public typealias Builder = (Destination) -> AnyView
    private let builder: Builder
    
    public init(builder: @escaping Builder) {
        self.builder = builder
    }
    
    public func navigate(route: any Hashable) {
        path.append(route)
    }
    
    public func popBackStack() {
        if path.isEmpty { return }
        
        path.removeLast()
    }
    
    @ViewBuilder
    public func navigate(route: Destination) -> AnyView {
        builder(route)
    }
}
