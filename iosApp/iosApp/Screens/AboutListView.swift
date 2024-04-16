//
//  AboutListView.swift
//  iosApp
//
//  Created by vitor.walcker on 08/04/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import shared
import SwiftUI

struct AboutListView: View {
    private struct RowItem: Hashable{
        let title: String
        let subtitle: String
    }
    
    private let items: [RowItem] = {
        let platform = Platform()
        platform.logSystemInfo()
        
        var result: [RowItem] = [
            .init(
                title: "Operating System",
                subtitle: "\(platform.osName) \(platform.osVersion)"
            ),
            .init(
                title: "Device",
                subtitle: platform.deviceModel
            ),
            .init(
                title: "Density",
                subtitle: "@\(platform.density)x"
            )
        ]
        return result
    }()
    
    var body: some View{
        List{
            ForEach(items, id: \.self){ item in
                VStack(alignment: .leading) {
                    Text(item.title)
                        .font(.footnote)
                        .foregroundStyle(.secondary)
                    Text(item.subtitle)
                        .font(.body)
                        .foregroundStyle(.primary)
                }
                .padding(.vertical, 4)
            }
        }
    }
}

struct AboutListView_Previews: PreviewProvider {
    static var previews: some View {
        AboutListView()
    }
}
