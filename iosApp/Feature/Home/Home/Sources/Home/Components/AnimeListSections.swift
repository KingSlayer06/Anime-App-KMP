//
//  SwiftUIView.swift
//  Home
//
//  Created by Himanshu Sherkar on 17/04/26.
//

import SwiftUI
import Shared
import Kingfisher

struct AnimeListSections: View {
    let title: String
    let animeList: [Anime_]
    let onClick: (Int32) -> Void
    let seeAll: () -> Void
    
    init(
        title: String,
        animeList: [Anime_],
        onClick: @escaping (Int32) -> Void,
        seeAll: @escaping () -> Void
    ) {
        self.title = title
        self.animeList = animeList
        self.onClick = onClick
        self.seeAll = seeAll
    }
    
    var body: some View {
        VStack(spacing: 16) {
            HStack {
                Text(title)
                    .font(.inter(size: 20, weight: .bold))
                    .foregroundStyle(Color.textPrimary)
                
                Spacer()
                
                Text("see all")
                    .font(.inter(size: 15, weight: .medium))
                    .foregroundStyle(Color.themeSecondary)
                    .onTapGesture { seeAll() }
            }
            .padding(.horizontal, 16)
            
            ScrollView(.horizontal, showsIndicators: false) {
                LazyHStack(spacing: 16) {
                    Group {
                        if animeList.isEmpty {
                            ForEach(0..<10) { _ in
                                AnimeCardSkeleton()
                            }
                        } else {
                            ForEach(animeList.prefix(upTo: 10), id: \.uuid) { anime in
                                AnimeCard(anime: anime, onClick: onClick)
                            }
                        }
                    }
                }
            }
        }
        .padding(.vertical, 8)
    }
}

private struct AnimeCard: View {
    let anime: Anime_
    let onClick: (Int32) -> Void
    
    init(
        anime: Anime_,
        onClick: @escaping (Int32) -> Void
    ) {
        self.anime = anime
        self.onClick = onClick
    }
    
    var body: some View {
        VStack(alignment: .leading, spacing: 4) {
            KFImage(URL(string: anime.image ?? ""))
                .resizable()
                .scaledToFill()
                .clipShape(RoundedRectangle(cornerRadius: 16))
            
            Text(anime.title)
                .font(.inter(size: 15))
                .foregroundStyle(Color.textPrimary)
                .lineLimit(1)
            
            HStack(spacing: 4) {
                Image(systemName: "heart.fill")
                    .resizable()
                    .frame(width: 15, height: 15)
                    .foregroundStyle(Color.textPrimary)
                
                Text(anime.favourites)
                    .font(.inter(size: 15))
                    .foregroundStyle(Color.textPrimary)
            }
        }
        .frame(width: 150)
        .contentShape(Rectangle())
        .onTapGesture {
            onClick(anime.uuid)
        }
    }
}

private struct AnimeCardSkeleton: View {
    var body: some View {
        VStack(alignment: .leading, spacing: 4) {
            Rectangle()
                .frame(width: 150, height: 200)
                .shimmerEffect()
                .clipShape(RoundedRectangle(cornerRadius: 16))
            
            Rectangle()
                .frame(width: 150 * 0.7, height: 15)
                .shimmerEffect()
                .clipShape(RoundedRectangle(cornerRadius: 4))
            
            Rectangle()
                .frame(width: 150 * 0.4, height: 15)
                .shimmerEffect()
                .clipShape(RoundedRectangle(cornerRadius: 4))
        }
        .frame(width: 150)
    }
}

#Preview {
    AnimeCardSkeleton()
}
