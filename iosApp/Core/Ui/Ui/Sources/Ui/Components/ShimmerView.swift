import SwiftUI

public struct Shimmer: ViewModifier {
    
    @State var isInitialState: Bool = true
    
    public init(isInitialState: Bool = true) {
        self.isInitialState = isInitialState
    }
    
    public func body(content: Content) -> some View {
        content
            .mask {
                LinearGradient(
                    gradient: .init(
                        colors: [
                            Color.surface.opacity(0.8),
                            Color.background.opacity(0.8),
                            Color.surface.opacity(0.8)
                        ]
                    ),
                    startPoint: (isInitialState ? .init(x: -0.3, y: -0.3) : .init(x: 1, y: 1)),
                    endPoint: (isInitialState ? .init(x: 0, y: 0) : .init(x: 1.3, y: 1.3))
                )
            }
            .animation(.easeOut(duration: 1.2).delay(0.25).repeatForever(autoreverses: false), value: isInitialState)
            .onAppear() {
                isInitialState = false
            }
    }
}

public extension View {
    func shimmerEffect() -> some View {
        self
            .redacted(reason: .placeholder)
            .modifier(Shimmer())
    }
}

#Preview {
    Rectangle()
        .frame(width: 300, height: 300)
        .shimmerEffect()
}
