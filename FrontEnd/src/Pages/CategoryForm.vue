<script setup>
import { ref, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import axios from "axios";
const route = useRoute();
const router = useRouter();
const category = ref({
  name: "",
});
const isEditing = ref(false);

const saveCategory = () => {
  if (isEditing.value) {
    axios
      .put(
        `http://localhost:8080/categories/${route.params.id}`,
        category.value
      )
      .then(() => router.push("/CategoryList"))
      .catch((error) => console.error("Error updating category:", error));
  } else {
    axios
      .post("http://localhost:8080/categories", category.value)
      .then(() => router.push("/CategoryList"))
      .catch((error) => console.error("Error adding category:", error));
  }
};
const fetchCategory = () => {
  if (route.params.id) {
    isEditing.value = true;
    axios
      .get(`http://localhost:8080/categories/${route.params.id}`)
      .then((response) => {
        category.value = response.data;
      })
      .catch((error) => console.error("Error fetching category:", error));
  }
};

onMounted(fetchCategory);
</script>
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
    <router-link to="/category-list" class="btn btn-secondary"
      >Back to Category List</router-link
    >
  </div>
</template>
