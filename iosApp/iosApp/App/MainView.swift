//
//  MainView.swift
//  iosApp
//
//  Created by Himanshu Sherkar on 15/04/26.
//

import SwiftUI
import Ui

struct MainView: View {
    var body: some View {
        VStack {
            Text("Hello World!")
                .font(.title)
            
            Text("Top Anime")
                .font(.inter(size: 20, weight: .bold))
                .fontWeight(.bold)
            
            Text("Top Anime")
                .font(Font.custom("Inter-Bold", size: 50))
                .fontWeight(.bold)
        }
        .scaledToFill()
        .foregroundStyle(Color.red)
    }
}

#Preview {
    MainView()
        .loadCustomFonts()
}
