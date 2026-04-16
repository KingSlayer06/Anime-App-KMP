//
//  SwiftUIView.swift
//  MyLibrary
//
//  Created by Himanshu Sherkar on 17/04/26.
//

import SwiftUI
import Ui

public struct MyLibrary: View {
    public init() { }
    
    public var body: some View {
        Text("MyLibrary View")
            .font(.inter(size: 20, weight: .bold))
            .frame(maxWidth: .infinity, maxHeight: .infinity)
    }
}

#Preview {
    MyLibrary()
}
