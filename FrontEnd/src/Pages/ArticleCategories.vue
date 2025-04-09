<template>
  <div class="categories-container">
    <h1>Browse Articles by Category</h1>
    <div class="category-list">
      <div
        class="category"
        v-for="category in categories"
        :key="category.id"
        @click="filterArticles(category.id)"
      >
        <img
          :src="category.image"
          :alt="category.name"
          class="category-image"
        />
        <p>{{ category.name }}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "ArticleCategories",
  data() {
    return {
      categories: [
        {
          id: 1,
          name: "Technology",
        },
        {
          id: 2,
          name: "Entertainment",
        },
        {
          id: 3,
          name: "Health",
        },
        // More categories...
      ],
    };
  },
  methods: {
    filterArticles(categoryId) {
      // Example redirection to filtered articles list based on category
      this.$router.push({
        name: "ArticleListByCategory",
        params: { categoryId },
      });
    },
  },
};
</script>

<style scoped>
.categories-container {
  text-align: center;
  padding: 20px;
}

h1 {
  font-size: 2rem;
  color: #333;
  margin-bottom: 20px;
}

.category-list {
  display: flex;
  justify-content: center;
  gap: 20px;
  flex-wrap: wrap;
}

.category {
  text-align: center;
  cursor: pointer;
}

.category-image {
  width: 150px;
  height: 150px;
  border-radius: 10px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

.category p {
  font-size: 1.1rem;
  margin-top: 10px;
}
</style>
