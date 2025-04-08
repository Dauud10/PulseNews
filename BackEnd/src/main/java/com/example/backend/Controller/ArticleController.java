package com.example.backend.Controller;

import com.example.backend.DTO.ArticleDTO;
import com.example.backend.Model.Article;
import com.example.backend.Service.ArticleService;
import com.example.backend.Service.CategoryService;
import com.example.backend.Mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/articles")
@Validated
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleMapper articleMapper;

    @GetMapping
    public ResponseEntity<List<ArticleDTO>> getAllArticles() {
        List<Article> articles = articleService.getAllArticles();
        List<ArticleDTO> articleDTOs = articleMapper.toDTOList(articles); // Convert to DTOs
        return ResponseEntity.ok(articleDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDTO> getArticleById(@PathVariable Long id) {
        Article article = articleService.getArticleById(id);
        if (article == null) {
            return ResponseEntity.notFound().build();
        }
        ArticleDTO articleDTO = articleMapper.toDTO(article); // Convert to DTO
        return ResponseEntity.ok(articleDTO);
    }

    @PostMapping
    public ResponseEntity<ArticleDTO> createArticle(@Valid @RequestBody ArticleDTO articleDTO) {
        Article article = articleMapper.toEntity(articleDTO); // Convert DTO to entity
        Article savedArticle = articleService.addArticle(article);
        ArticleDTO savedArticleDTO = articleMapper.toDTO(savedArticle); // Convert back to DTO
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticleDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleDTO> updateArticle(@PathVariable Long id, @Valid @RequestBody ArticleDTO articleDTO) {
        Article existingArticle = articleService.getArticleById(id);
        if (existingArticle == null) {
            return ResponseEntity.notFound().build();
        }
        articleDTO.setId(id); // Ensure correct ID
        Article article = articleMapper.toEntity(articleDTO); // Convert DTO to entity
        Article savedArticle = articleService.addArticle(article);
        ArticleDTO savedArticleDTO = articleMapper.toDTO(savedArticle); // Convert back to DTO
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

