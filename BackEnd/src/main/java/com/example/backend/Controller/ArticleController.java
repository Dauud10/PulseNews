package com.example.backend.Controller;

import com.example.backend.DTO.ArticleDTO;  // Correct import
import com.example.backend.Model.Article;
import com.example.backend.Model.Category;
import com.example.backend.Service.ArticleService;
import com.example.backend.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:8084")
@RestController
@RequestMapping("/articles")
@Validated
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryService categoryService;

    private ArticleDTO convertToDTO(Article article) {
        ArticleDTO dto = new ArticleDTO();
        dto.setTitle(article.getTitle());
        dto.setContent(article.getContent());
        dto.setAuthor(article.getAuthor());
        dto.setCategoryId(article.getCategory().getId());
        return dto;
    }

    private Article convertToEntity(ArticleDTO dto) {
        Article article = new Article();
        article.setTitle(dto.getTitle());
        article.setContent(dto.getContent());
        article.setAuthor(dto.getAuthor());
        article.setPublishedAt(LocalDate.now());
        Category category = categoryService.getCategoryById(dto.getCategoryId());
        article.setCategory(category);
        return article;
    }

    @GetMapping
    public ResponseEntity<List<ArticleDTO>> getAllArticles() {
        List<Article> articles = articleService.getAllArticles();
        List<ArticleDTO> dtoList = articles.stream().map(this::convertToDTO).collect(Collectors.toList());
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDTO> getArticleById(@PathVariable Long id) {
        Article article = articleService.getArticleById(id);
        if (article == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(convertToDTO(article));
    }

    @PostMapping
    public ResponseEntity<ArticleDTO> createArticle(@Valid @RequestBody ArticleDTO dto) {
        Article saved = articleService.addArticle(convertToEntity(dto));
        return new ResponseEntity<>(convertToDTO(saved), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable Long id) {
        boolean deleted = articleService.deleteArticleById(id);
        if (!deleted) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Article not found!");
        return ResponseEntity.ok("Article deleted successfully!");
    }
}


