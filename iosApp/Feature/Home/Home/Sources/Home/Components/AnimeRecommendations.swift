//
//  SwiftUIView.swift
//  Home
//
//  Created by Himanshu Sherkar on 17/04/26.
//

import SwiftUI
import Shared
import Ui
import Kingfisher

struct AnimeRecommendations: View {
    var animeList: [Anime_]
    var onClick: (Int32) -> Void
    
    init(
        animeList: [Anime_],
        onClick: @escaping (Int32) -> Void
    ) {
        self.animeList = animeList
        self.onClick = onClick
    }
    
    var body: some View {
        Group {
            if animeList.isEmpty {
                AnimeCardSkeleton()
            } else {
                AutoScrollCarousel(animeList) { item in
                    AnimeCard(anime: item, onClick: onClick)
                }
            }
        }
        .frame(height: 220)
    }
}

private struct AnimeCard: View {
    private var anime: Anime_
    private var onClick: (Int32) -> Void
    
    init(anime: Anime_, onClick: @escaping (Int32) -> Void) {
        self.anime = anime
        self.onClick = onClick
    }
    
    var body: some View {
        ZStack(alignment: .bottomLeading) {
            KFImage(URL(string: anime.image ?? ""))
                .resizable()
                .scaledToFill()
                .clipShape(Rectangle())
                .overlay {
                    LinearGradient(
                        colors: [Color.clear, Color.background.opacity(0.5)],
                        startPoint: .top,
                        endPoint: .bottom
                    )
                }
            
            VStack(alignment: .leading) {
                Text(anime.title)
                    .font(.inter(size: 25, weight: .bold))
                    .foregroundStyle(Color.textPrimary)
                    .lineLimit(1)
                
                HStack(spacing: 8) {
                    Image(systemName: "heart.fill")
                        .resizable()
                        .frame(width: 20, height: 20)
                        .foregroundStyle(Color.textPrimary)
                    
                    Text(anime.favourites)
                        .font(.inter(size: 20))
                        .foregroundStyle(Color.textPrimary)
                }
            }
            .padding(.leading, 16)
            .padding(.bottom, 16)
        }
        .contentShape(Rectangle())
        .onTapGesture {
            onClick(anime.uuid)
        }
    }
}

private struct AnimeCardSkeleton: View {
    var body: some View {
        Rectangle()
            .frame(height: 220)
            .shimmerEffect()
    }
}

#Preview {
    AnimeRecommendations(animeList: [], onClick: { _ in })
}
