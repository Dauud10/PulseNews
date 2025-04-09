<template>
  <div class="container">
    <h2>Article List</h2>
    <router-link to="/add-article" class="btn btn-success mb-3"
      >Add Article</router-link
    >
    <router-link to="/admin-dashboard" class="btn btn-success mb-3"
      >Back to Admin Dashboard</router-link
    >

    <div
      v-if="successMessage"
      class="alert alert-success alert-dismissible fade show"
    >
      {{ successMessage }}
      <button
        type="button"
        class="btn-close"
        @click="successMessage = ''"
      ></button>
    </div>

    <table class="table">
      <thead>
        <tr>
          <th>Title</th>
          <th>Author</th>
          <th>Published At</th>
          <th>Category</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="article in articleList" :key="article.id">
          <td>{{ article.title }}</td>
          <td>{{ article.author }}</td>
          <td>{{ article.publishedAt }}</td>
          <td>{{ article.category }}</td>
          <td>
            <router-link
              :to="`/edit-article/${article.id}`"
              class="btn btn-warning me-2"
              >Edit</router-link
            >
            <button class="btn btn-danger" @click="showDeleteModal(article)">
              Delete
            </button>
          </td>
        </tr>
      </tbody>
    </table>

    <div class="modal fade" id="deleteModal" tabindex="-1" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">Confirm Delete</h5>
            <button
              type="button"
              class="btn-close"
              data-bs-dismiss="modal"
              aria-label="Close"
            ></button>
          </div>
          <div class="modal-body">
            <p>
              Are you sure you want to delete
              <strong>{{ selectedArticle.title }}</strong
              >?
            </p>
          </div>
          <div class="modal-footer">
            <button class="btn btn-danger" @click="deleteArticle">
              Yes, Delete
            </button>
            <button class="btn btn-secondary" data-bs-dismiss="modal">
              Cancel
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import axios from "axios";
import { Modal } from "bootstrap";

const articleList = ref([]);
const successMessage = ref("");
const selectedArticle = ref({});

let deleteModalInstance = null;

const fetchArticles = () => {
  axios
    .get("http://localhost:8080/articles")
    .then((response) => {
      articleList.value = response.data;
    })
    .catch((error) => console.error("Error fetching articles:", error));
};

const showDeleteModal = (article) => {
  selectedArticle.value = article;
  deleteModalInstance = new Modal(document.getElementById("deleteModal"));
  deleteModalInstance.show();
};

const deleteArticle = () => {
  axios
    .delete(`http://localhost:8080/articles/${selectedArticle.value.id}`)
    .then(() => {
      successMessage.value = "Article deleted successfully!";
      fetchArticles();
      deleteModalInstance.hide();
    })
    .catch((error) => console.error("Error deleting article:", error));
};

onMounted(fetchArticles);
</script>

<style scoped>
.btn {
  margin: 20px;
  background-color: #ff4242; /* Red background for consistency */
  color: white;
  border: none;
  border-radius: 5px;
  padding: 10px 20px;
  font-size: 1rem;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.btn:hover {
  background-color: #d93636; /* Darker red on hover */
}

.btn:focus {
  outline: none;
  box-shadow: 0 0 0 2px rgba(255, 66, 66, 0.5); /* Subtle outline on focus */
}
</style>
