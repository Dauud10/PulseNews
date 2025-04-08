<template>
  <div class="admin-page">
    <h1>Welcome, {{ adminName }}</h1>
    <p>Manage Articles:</p>
    <div class="article-list">
      <div
        v-for="(article, index) in articles"
        :key="index"
        class="article-item"
      >
        <h2>{{ article.title }}</h2>
        <p>{{ article.description }}</p>
        <div class="article-actions">
          <button @click="editArticle(article.id)">Edit Article</button>
          <button @click="updateArticle(article.id)">Update Article</button>
          <button @click="deleteArticle(article.id)">Delete Article</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "AdminPage",
  data() {
    return {
      adminName: this.$route.query.admin || "Admin",
      articles: [
        { id: 1, title: "Article 1", description: "Description for article 1" },
        { id: 2, title: "Article 2", description: "Description for article 2" },
        { id: 3, title: "Article 3", description: "Description for article 3" },
      ],
    };
  },
  methods: {
    editArticle(id) {
      alert(`Editing article ${id}`);
    },
    updateArticle(id) {
      alert(`Updating article ${id}`);
    },
    deleteArticle(id) {
      this.articles = this.articles.filter((article) => article.id !== id);
    },
  },
};
</script>

<style scoped>
.admin-page {
  background-color: red;
  color: black;
  padding: 20px;
  min-height: 100vh;
}

h1 {
  color: #ff4242;
  margin-bottom: 20px;
}

.article-list {
  display: flex;
  flex-direction: column;
  gap: 20px;
}

.article-item {
  background: #202020;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
}

.article-actions {
  margin-top: 10px;
  display: flex;
  gap: 10px;
}

button {
  padding: 8px 12px;
  color: #fff;
  background-color: #ff4242;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background 0.3s;
}

button:hover {
  background-color: #d93636;
}
</style>
