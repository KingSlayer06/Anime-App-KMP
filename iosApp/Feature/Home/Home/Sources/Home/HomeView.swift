//
//  SwiftUIView.swift
//  Home
//
//  Created by Himanshu Sherkar on 15/04/26.
//

import SwiftUI
import Ui
import Shared

public struct HomeView: View {
    @StateObject private var viewModel: HomeViewModelSwift = HomeViewModelSwift()
    
    private var onClick: (Int32) -> Void
    
    public init(onClick: @escaping (Int32) -> Void) {
        self.onClick = onClick
    }
    
    public var body: some View {
        HomeViewContent(
            state: viewModel.state,
            onClick: onClick
        )
    }
}

private struct HomeViewContent: View {
    private var state: HomeUiState
    private var onClick: (Int32) -> Void
    
    init(
        state: HomeUiState,
        onClick: @escaping (Int32) -> Void
    ) {
        self.state = state
        self.onClick = onClick
    }
    
    var body: some View {
        ScrollView(.vertical, showsIndicators: false) {
            LazyVStack(spacing: 8) {
                AnimeRecommendations(
                    animeList: state.recommendations,
                    onClick: onClick
                )
                
                AnimeListSections(
                    title: "Top Anime",
                    animeList: state.topAnime,
                    onClick: onClick,
                    seeAll: {}
                )
                
                AnimeListSections(
                    title: "This Season",
                    animeList: state.thisSeason,
                    onClick: onClick,
                    seeAll: {}
                )
                
                AnimeListSections(
                    title: "Coming Soon",
                    animeList: state.upcomingSeason,
                    onClick: onClick,
                    seeAll: {}
                )
            }
        }
    }
}

#Preview {
    let state = HomeUiState(
        isLoading: false,
        recommendations: [],
        topAnime: [],
        thisSeason: [],
        upcomingSeason: [],
        errorMessage: nil
    )
    
    HomeViewContent(state: state) { _ in
        
    }
}
