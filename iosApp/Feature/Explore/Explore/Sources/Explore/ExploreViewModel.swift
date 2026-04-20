//
//  File.swift
//  Explore
//
//  Created by Himanshu Sherkar on 20/04/26.
//

import Foundation
import Shared

@MainActor
final class ExploreViewModelSwift: ObservableObject {
    private let viewModel: ExploreViewModel
    private var task: Task<Void, Never>?
    
    @Published private(set) var state: ExploreUiState
    
    
    init(
        viewModel: ExploreViewModel = ExploreViewModelProvider().provideExploreViewModel()
    ) {
        self.viewModel = viewModel
        self.state = viewModel.state.value
        self.task = Task {
            for await state in viewModel.state {
                self.state = state
            }
        }
    }
    
    deinit { task?.cancel() }
}
