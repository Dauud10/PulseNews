package com.example.backend.Controller;

import com.example.backend.DTO.ArticleDTO;
import com.example.backend.Model.Article;
import com.example.backend.Service.ArticleService;
import com.example.backend.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/articles")
@Validated
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryService categoryService;

    // Convert an Article entity to ArticleDTO manually
    private ArticleDTO convertToDTO(Article article) {
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setId(article.getId());
        articleDTO.setTitle(article.getTitle());
        articleDTO.setContent(article.getContent());
        articleDTO.setAuthor(article.getAuthor());
        articleDTO.setPublishedAt(article.getPublishedAt());
        articleDTO.setCategoryId(article.getCategory().getId()); // Assuming Article has Category reference.
        return articleDTO;
    }

    // Convert a list of Article entities to a list of ArticleDTOs
    private List<ArticleDTO> convertToDTOList(List<Article> articles) {
        return articles.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping
    public ResponseEntity<List<ArticleDTO>> getAllArticles() {
        List<Article> articles = articleService.getAllArticles();
        List<ArticleDTO> articleDTOs = convertToDTOList(articles); // Convert to DTOs manually
        return ResponseEntity.ok(articleDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDTO> getArticleById(@PathVariable Long id) {
        Article article = articleService.getArticleById(id);
        if (article == null) {
            return ResponseEntity.notFound().build();
        }
        ArticleDTO articleDTO = convertToDTO(article); // Convert to DTO manually
        return ResponseEntity.ok(articleDTO);
    }

    @PostMapping
    public ResponseEntity<ArticleDTO> createArticle(@Valid @RequestBody ArticleDTO articleDTO) {
        Article article = new Article();
        article.setTitle(articleDTO.getTitle());
        article.setContent(articleDTO.getContent());
        article.setAuthor(articleDTO.getAuthor());
        article.setPublishedAt(articleDTO.getPublishedAt());
        article.setCategory(categoryService.getCategoryById(articleDTO.getCategoryId())); // Assuming you are fetching Category by ID
        Article savedArticle = articleService.addArticle(article);
        ArticleDTO savedArticleDTO = convertToDTO(savedArticle); // Convert back to DTO manually
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticleDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleDTO> updateArticle(@PathVariable Long id, @Valid @RequestBody ArticleDTO articleDTO) {
        Article existingArticle = articleService.getArticleById(id);
        if (existingArticle == null) {
            return ResponseEntity.notFound().build();
        }
        existingArticle.setTitle(articleDTO.getTitle());
        existingArticle.setContent(articleDTO.getContent());
        existingArticle.setAuthor(articleDTO.getAuthor());
        existingArticle.setPublishedAt(articleDTO.getPublishedAt());
        existingArticle.setCategory(categoryService.getCategoryById(articleDTO.getCategoryId())); // Assuming Category reference

        Article savedArticle = articleService.addArticle(existingArticle);
        ArticleDTO savedArticleDTO = convertToDTO(savedArticle); // Convert back to DTO manually
        return ResponseEntity.ok(savedArticleDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable Long id) {
        boolean isDeleted = articleService.deleteArticleById(id);
        if (!isDeleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Article not found!");
        }
        return ResponseEntity.ok("Article deleted successfully!");
    }
}

