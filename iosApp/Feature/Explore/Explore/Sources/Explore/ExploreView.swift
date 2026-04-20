//
//  SwiftUIView.swift
//  Explore
//
//  Created by Himanshu Sherkar on 17/04/26.
//

import SwiftUI
import Ui
import Shared

public struct ExploreView: View {
    @StateObject var viewModel: ExploreViewModelSwift = ExploreViewModelSwift()
    
    private var onClick: (Int32) -> Void
    
    public init(onClick: @escaping (Int32) -> Void) {
        self.onClick = onClick
    }
    
    public var body: some View {
        ExploreViewContent(
            state: viewModel.state,
            onClick: onClick
        )
    }
}

private struct ExploreViewContent: View {
    private let state: ExploreUiState
    private var onClick: (Int32) -> Void
    
    init(
        state: ExploreUiState,
        onClick: @escaping (Int32) -> Void
    ) {
        self.state = state
        self.onClick = onClick
    }
    
    var body: some View {
        
    }
}

#Preview {
    ExploreView(onClick: { _ in })
}
