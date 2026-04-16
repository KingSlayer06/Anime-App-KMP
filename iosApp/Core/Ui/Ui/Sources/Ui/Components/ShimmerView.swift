import SwiftUI

private struct ShimmerGradient: View {
    @State private var isInitialState = true
    
    var body: some View {
        LinearGradient(
            stops: [
                .init(color: Color.surface.opacity(0.8), location: 0.0),
                .init(color: Color.background.opacity(0.8), location: 0.5),
                .init(color: Color.surface.opacity(0.8), location: 1.0),
            ],
            startPoint: isInitialState ? .init(x: -0.3, y: -0.3) : .init(x: 1, y: 1),
            endPoint: isInitialState ? .init(x: 0, y: 0) : .init(x: 1.3, y: 1.3)
        )
        .animation(.linear(duration: 2).delay(0.25).repeatForever(autoreverses: false), value: isInitialState)
        .onAppear { isInitialState = false }
    }
}

private struct ShimmerEffect: ViewModifier {
    
    @ViewBuilder
    func body(content: Content) -> some View {
        content
            .overlay(ShimmerGradient()
            .mask(content))
    }
}

public extension View {
    
    @ViewBuilder
    func shimmerEffect() -> some View {
        modifier(ShimmerEffect())
    }
}

#Preview {
    RoundedRectangle(cornerRadius: 16)
        .frame(width: 150, height: 200)
        .shimmerEffect()
}
