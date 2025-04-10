<template>
  <div class="categories">
    <!-- Hero Section -->
    <section class="hero text-center">
      <img src="@/icons/pulsenews.png" alt="Pulse News Logo" class="logo" />
      <h1>Explore Articles by Category</h1>
      <p class="subtitle">Browse our articles by category and stay informed.</p>
    </section>

    <!-- Categories Section -->
    <section class="categories-section container">
      <h2 class="section-title">Categories</h2>
      <div class="row">
        <div
          class="col-md-4 mb-4"
          v-for="category in categories"
          :key="category.id"
          @click="filterArticles(category.id)"
        >
          <div class="category-card h-100">
            <div class="category-body">
              <h5 class="category-title">{{ category.name }}</h5>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "ArticleCategories",
  data() {
    return {
      categories: [], // Fetch categories from backend
    };
  },
  mounted() {
    this.fetchCategories(); // Fetch categories on page load
  },
  methods: {
    fetchCategories() {
      axios
        .get("http://localhost:8080/categories") // Adjust URL as needed
        .then((response) => {
          this.categories = response.data;
        })
        .catch((error) => {
          console.error("Error fetching categories:", error);
        });
    },
    filterArticles(categoryId) {
      this.$router.push({
        name: "ArticleListByCategory",
        params: { categoryId }, // Pass categoryId to the article list
      });
    },
  },
};
</script>

<style scoped>
.categories {
  background: #1a1a1a;
  color: white;
  min-height: 100vh;
  padding: 20px;
}

.logo {
  width: 180px;
  height: auto;
  margin-bottom: 20px;
}

.subtitle {
  font-size: 1.2rem;
  color: #cccccc;
}

.section-title {
  font-size: 2rem;
  margin: 40px 0 20px;
  color: #ff4242;
  text-align: center;
}

.category-card {
  background-color: #2a2a2a;
  color: white;
  border: none;
  border-radius: 12px;
  box-shadow: 0 0 10px rgba(255, 66, 66, 0.2);
  cursor: pointer;
  padding: 20px;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 150px;
}

.category-title {
  color: #ff4242;
  font-weight: bold;
  text-align: center;
}
</style>
