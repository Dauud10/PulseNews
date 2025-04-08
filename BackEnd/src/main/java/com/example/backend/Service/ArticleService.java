package com.example.backend.Service;

import com.example.backend.Model.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getAllArticles();
    Article addArticle(Article article);
    Article getArticleById(Long id);
    boolean deleteArticleById(Long id);
}
