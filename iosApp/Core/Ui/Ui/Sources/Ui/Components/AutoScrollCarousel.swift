//
//  SwiftUIView.swift
//  Ui
//
//  Created by Himanshu Sherkar on 16/04/26.
//

import SwiftUI
import Combine

public struct AutoScrollCarousel<Data, Content>: View
where Data: RandomAccessCollection, Content: View {
    
    private let items: [Data.Element]
    private let height: CGFloat
    private let interval: TimeInterval
    private let resumeDelay: TimeInterval
    private let animation: Animation
    private let pausesWhileInteracting: Bool
    private let content: (Data.Element) -> Content
    
    @State private var index: Int = 0
    @State private var isInteracting = false
    @State private var resumeWorkItem: DispatchWorkItem?
    
    public init(
        _ items: Data,
        height: CGFloat = 220,
        interval: TimeInterval = 3,
        resumeDelay: TimeInterval = 0.8,
        animation: Animation = .easeInOut(duration: 0.8),
        pausesWhileInteracting: Bool = true,
        @ViewBuilder content: @escaping (Data.Element) -> Content
    ) {
        self.items = Array(items)
        self.height = height
        self.interval = interval
        self.resumeDelay = resumeDelay
        self.animation = animation
        self.pausesWhileInteracting = pausesWhileInteracting
        self.content = content
        
        UITabBar.appearance().isHidden = true
    }
    
    public var body: some View {
        TabView(selection: $index) {
            ForEach(Array(items.enumerated()), id: \.offset) { i, item in
                content(item).tag(i)
            }
            .frame(height: height)
        }
        .tabViewStyle(.page(indexDisplayMode: .never))
        .overlay(alignment: .bottomLeading) {
            CarouselDots(count: items.count, index: index)
        }
        .frame(height: height)
        .contentShape(Rectangle())
        .simultaneousGesture(
            DragGesture(minimumDistance: 1)
                .onChanged { _ in
                    isInteracting = true
                    resumeWorkItem?.cancel()
                    resumeWorkItem = nil
                }
                .onEnded { _ in
                    let work = DispatchWorkItem { isInteracting = false }
                    resumeWorkItem = work
                    DispatchQueue.main.asyncAfter(deadline: .now() + resumeDelay, execute: work)
                }
        )
        .onReceive(
            Timer.publish(every: interval, on: .main, in: .common)
            .autoconnect()
        ) { _ in
            guard items.count > 1 else { return }
            if pausesWhileInteracting && isInteracting { return }
            
            withAnimation(animation) {
                index = (index + 1) % items.count
            }
        }
    }
}

private struct CarouselDots: View {
    let count: Int
    let index: Int
    var activeColor: Color
    var inactiveColor: Color
    var size: CGFloat
    var spacing: CGFloat
    
    init(
        count: Int,
        index: Int,
        activeColor: Color = Color.textPrimary,
        inactiveColor: Color = Color.textPrimary.opacity(0.5),
        size: CGFloat = 10,
        spacing: CGFloat = 8
    ) {
        self.count = count
        self.index = index
        self.activeColor = activeColor
        self.inactiveColor = inactiveColor
        self.size = size
        self.spacing = spacing
    }
    
    var body: some View {
        HStack(spacing: spacing) {
            ForEach(0..<count, id: \.self) { i in
                let isSelected = i == index
                Capsule()
                    .fill(isSelected ? activeColor : inactiveColor)
                    .frame(width: isSelected ? size * 2 : size, height: size)
                    .animation(.easeInOut(duration: 0.2), value: index)
            }
        }
        .padding(.horizontal, 16)
        .padding(.vertical, 16)
    }
}

#Preview {
    VStack {
        Spacer()
        
        let list = [Color.red, Color.blue, Color.green, Color.purple]
        AutoScrollCarousel(list) { item in
            item
        }
        
        Spacer()
    }
    .appBackground()
}
