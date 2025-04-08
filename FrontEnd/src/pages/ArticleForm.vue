<template>
  <div class="container">
    <h2 class="mt-4">{{ isEditing ? "Update Article" : "Add Article" }}</h2>

    <form @submit.prevent="saveArticle">
      <!-- Title -->
      <div class="mb-3">
        <label class="form-label">Title:</label>
        <input
          type="text"
          v-model="article.title"
          placeholder="Article Title"
          class="form-control"
          required
        />
      </div>

      <!-- Content -->
      <div class="mb-3">
        <label class="form-label">Content:</label>
        <textarea
          v-model="article.content"
          placeholder="Article Content"
          class="form-control"
          required
        ></textarea>
      </div>

      <!-- Author -->
      <div class="mb-3">
        <label class="form-label">Author:</label>
        <input
          type="text"
          v-model="article.author"
          placeholder="Author Name"
          class="form-control"
          required
        />
      </div>

      <!-- Published At -->
      <div class="mb-3">
        <label class="form-label">Published At:</label>
        <input
          type="date"
          v-model="article.publishedAt"
          class="form-control"
          required
        />
      </div>

      <!-- Category -->
      <div class="mb-3">
        <label class="form-label">Category:</label>
        <input
          type="text"
          v-model="article.category"
          placeholder="Article Category"
          class="form-control"
          required
        />
      </div>

      <button type="submit" class="btn btn-primary">
        {{ isEditing ? "Update Article" : "Add Article" }}
      </button>
    </form>

    <hr />

    <router-link to="/articlelist" class="btn btn-secondary"
      >Back to Article List</router-link
    >
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import axios from "axios";

const route = useRoute();
const router = useRouter();

const article = ref({
  title: "",
  content: "",
  author: "",
  publishedAt: "",
  category: "",
});

const isEditing = ref(false);

const saveArticle = () => {
  if (isEditing.value) {
    axios
      .put(`http://localhost:8080/articles/${route.params.id}`, article.value)
      .then(() => router.push("/articlelist"))
      .catch((error) => console.error("Error updating article:", error));
  } else {
    axios
      .post("http://localhost:8080/articles", article.value)
      .then(() => router.push("/articlelist"))
      .catch((error) => console.error("Error adding article:", error));
  }
};

const fetchArticle = () => {
  if (route.params.id) {
    isEditing.value = true;
    axios
      .get(`http://localhost:8080/articles/${route.params.id}`)
      .then((response) => {
        article.value = response.data;
      })
      .catch((error) => console.error("Error fetching article:", error));
  }
};

onMounted(fetchArticle);
</script>
