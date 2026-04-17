//
//  File.swift
//  Home
//
//  Created by Himanshu Sherkar on 17/04/26.
//

import Foundation
import Shared

@MainActor
final class HomeViewModelSwift: ObservableObject {
    private let viewModel: HomeViewModel
    private var task: Task<Void, Never>?
    
    @Published private(set) var state: HomeUiState
    
    init(
        viewModel: HomeViewModel = HomeViewModelProvider().provideHomeViewModel()
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
