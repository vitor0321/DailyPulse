//
//  ArticlesScreen.swift
//  iosApp
//
//  Created by vitor.walcker on 15/04/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

extension ArticlesScreen {
    
    @MainActor
    class ArticlesViewModelWrapper: ObservableObject {
        let articlesViewModel: ArticlesViewModel
        
        init() {
            articlesViewModel = ArticlesInjector().articlesViewModel
            articlesState = articlesViewModel.articlesState.value
        }
        
        @Published var articlesState: ArticlesState
        
        func startObserving() {
            Task {
                for await articlseS in articlesViewModel.articlesState {
                    self.articlesState = articlseS
                }
            }
        }
    }
}

struct ArticlesScreen: View {

    @ObservedObject private(set) var viewModel: ArticlesViewModelWrapper
    
    var body: some View{
        VStack {
            AppBar()
            
            if viewModel.articlesState.loading {
                Loader()
            }
            
            if let error = viewModel.articlesState.error {
                ErrorMessage(message: error)
            }
            
            if (!viewModel.articlesState.articles.isEmpty){
                ScrollView {
                    LazyVStack(spacing: 10){
                        ForEach(viewModel.articlesState.articles, id: \.self) { article in
                            ArticleItemView(article: article)
                        }
                    }
                }
            }
        }.onAppear{
            self.viewModel.startObserving()
        }
    }
}

struct AppBar: View {
    var body: some View{
        Text("Articles")
            .font(.largeTitle)
            .fontWeight(.bold)
    }
}

struct ArticleItemView: View {
    var article: Article
    
    var body: some View {
        VStack(alignment: .leading, spacing: 8){
            if let imageUrl = article.imageUrl, let url = URL(string: imageUrl) {
                AsyncImage(url: url) { phase in
                    switch phase {
                    case .empty:
                        VStack {
                            HStack {
                                ProgressView().progressViewStyle(CircularProgressViewStyle())
                            }
                        }
                        .frame(maxWidth: .infinity, minHeight: 190)
                        
                    case .success(let image):
                        image
                            .resizable()
                            .aspectRatio(contentMode: .fit)
                    
                    case .failure(_):
                        Image("errorImage")
                            .resizable()
                            .aspectRatio(contentMode: .fit)
                            .frame(maxWidth: .infinity, minHeight: 190)
                    @unknown default:
                        VStack {
                            HStack {
                                Text("Insepct wrong! try again")
                            }
                        }
                        .frame(maxWidth: .infinity, minHeight: 190)
                    }
                    
                }
            } else {
                Image("errorImage")
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .frame(maxWidth: .infinity, minHeight: 190)
            }
            
            Text(article.title)
                .font(.title)
                .fontWeight(.bold)
            
            if let subTitle = article.subTitle {
                Text(subTitle)
            }
        
            Text(article.date)
                .frame(
                    maxWidth: .infinity,
                    alignment: .trailing
                )
                .foregroundStyle(.gray)
        }
        .padding(16)
    }
}

struct Loader: View {
    var body: some View {
        ProgressView()
    }
}

struct ErrorMessage: View {
    var message: String
    
    var body: some View {
        Text(message)
            .font(.title)
    }
}
