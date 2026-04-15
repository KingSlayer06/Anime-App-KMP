//
//  SwiftUIView.swift
//  Details
//
//  Created by Himanshu Sherkar on 15/04/26.
//

import SwiftUI

public struct DetailsView: View {
    public let id: Int
    
    public init(id: Int) {
        self.id = id
    }
    
    public var body: some View {
        Text("Details View")
    }
}

#Preview {
    DetailsView(id: 0)
}
