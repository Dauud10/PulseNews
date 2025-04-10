<template>
  <div class="container">
    <h2 class="mt-4">{{ isEditing ? "Update Category" : "Add Category" }}</h2>

    <form @submit.prevent="saveCategory">
      <!-- Name -->
      <div class="form-group">
        <label>Name:</label>
        <input
          type="text"
          v-model="category.name"
          placeholder="Category Name"
          class="form-control"
          required
        />
      </div>

      <!-- Submit Button -->
      <button type="submit" class="btn btn-primary">
        {{ isEditing ? "Update Category" : "Add Category" }}
      </button>
    </form>

    <hr />
    <!-- Back to Category List -->
    <router-link to="/category-list" class="btn btn-secondary">
      Back to Category List
    </router-link>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "CategoryForm",
  data() {
    return {
      category: {
        name: "",
      },
      isEditing: false,
    };
  },
  mounted() {
    if (this.$route.params.id) {
      this.isEditing = true;
      this.fetchCategory();
    }
  },
  methods: {
    // Fetch category details when editing
    fetchCategory() {
      axios
        .get(`http://localhost:8080/categories/${this.$route.params.id}`)
        .then((response) => {
          this.category = response.data;
        })
        .catch((error) => console.error("Error fetching category:", error));
    },

    // Save category (either add or update)
    saveCategory() {
      const url = this.isEditing
        ? `http://localhost:8080/categories/${this.$route.params.id}`
        : "http://localhost:8080/categories";
      const method = this.isEditing ? "put" : "post";

      axios[method](url, this.category)
        .then(() => {
          this.$router.push("/category-list");
        })
        .catch((error) => console.error("Error saving category:", error));
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
