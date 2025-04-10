<template>
  <div class="container">
    <h2 class="mt-4">{{ isEditing ? "Update Article" : "Add Article" }}</h2>

    <form @submit.prevent="saveArticle">
      <!-- Title -->
      <div class="form-group">
        <label>Title:</label>
        <input
          type="text"
          v-model="article.title"
          placeholder="Article Title"
          class="form-control"
          required
        />
      </div>

      <!-- Content -->
      <div class="form-group">
        <label>Content:</label>
        <textarea
          v-model="article.content"
          placeholder="Article Content"
          class="form-control"
          required
        ></textarea>
      </div>

      <!-- Author -->
      <div class="form-group">
        <label>Author:</label>
        <input
          type="text"
          v-model="article.author"
          placeholder="Author Name"
          class="form-control"
          required
        />
      </div>

      <!-- Published At -->
      <div class="form-group">
        <label>Published At:</label>
        <input
          type="date"
          v-model="article.publishedAt"
          class="form-control"
          required
        />
      </div>

      <!-- Category -->
      <div class="form-group">
        <label>Category:</label>
        <select v-model="article.category" class="form-control" required>
          <option
            v-for="category in categories"
            :key="category.id"
            :value="category.id"
          >
            {{ category.name }}
          </option>
        </select>
      </div>

      <button type="submit" class="btn btn-primary">
        {{ isEditing ? "Update Article" : "Add Article" }}
      </button>
    </form>

    <hr />
    <router-link to="/article-list" class="btn btn-secondary"
      >Back to Article List</router-link
    >
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "ArticleForm",
  data() {
    return {
      article: {
        title: "",
        content: "",
        author: "",
        publishedAt: "",
        category: "",
      },
      categories: [],
      isEditing: false,
    };
  },
  mounted() {
    this.fetchCategories();
    if (this.$route.params.id) {
      this.isEditing = true;
      this.fetchArticle();
    }
  },
  methods: {
    fetchCategories() {
      axios
        .get("http://localhost:8080/categories")
        .then((response) => {
          this.categories = response.data;
        })
        .catch((error) => console.error("Error fetching categories:", error));
    },
    fetchArticle() {
      axios
        .get(`http://localhost:8080/articles/${this.$route.params.id}`)
        .then((response) => {
          this.article = response.data;
        })
        .catch((error) => console.error("Error fetching article:", error));
    },
    saveArticle() {
      const url = this.isEditing
        ? `http://localhost:8080/articles/${this.$route.params.id}`
        : "http://localhost:8080/articles";

      const method = this.isEditing ? "put" : "post";

      axios[method](url, this.article)
        .then(() => {
          this.$router.push("/article-list");
        })
        .catch((error) => console.error("Error saving article:", error));
    },
  },
};
</script>

<style scoped>
.container {
  margin-top: 20px;
}

.form-group {
  margin-bottom: 20px;
}

.btn {
  background-color: #ff4242;
  color: white;
}
</style>
