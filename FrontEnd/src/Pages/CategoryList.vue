<template>
  <div class="container">
    <h2>Category List</h2>
    <router-link to="/add-category" class="btn btn-success mb-3"
      >Add Category</router-link
    >
    <router-link to="/admin-dashboard" class="btn btn-success mb-3"
      >Back to Admin Dashboard</router-link
    >

    <div
      v-if="successMessage"
      class="alert alert-success alert-dismissible fade show"
    >
      {{ successMessage }}
      <button type="button" class="close" @click="successMessage = ''">
        &times;
      </button>
    </div>

    <table class="table">
      <thead>
        <tr>
          <th>Name</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="category in categoryList" :key="category.id">
          <td>{{ category.name }}</td>
          <td>
            <router-link
              :to="'/edit-category/' + category.id"
              class="btn btn-warning"
              >Edit</router-link
            >
            <button class="btn btn-danger" @click="showDeleteModal(category)">
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
              <strong>{{ selectedCategory.name }}</strong
              >?
            </p>
          </div>
          <div class="modal-footer">
            <button class="btn btn-danger" @click="deleteCategory">
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

const categoryList = ref([]);
const successMessage = ref("");
const selectedCategory = ref({});
let deleteModalInstance = null;

const fetchCategories = () => {
  axios
    .get("http://localhost:8080/categories")
    .then((response) => {
      categoryList.value = response.data;
    })
    .catch((error) => console.error("Error fetching categories:", error));
};

const showDeleteModal = (category) => {
  selectedCategory.value = category;
  deleteModalInstance = new Modal(document.getElementById("deleteModal"));
  deleteModalInstance.show();
};

const deleteCategory = () => {
  axios
    .delete(`http://localhost:8080/categories/${selectedCategory.value.id}`)
    .then(() => {
      successMessage.value = "Category deleted successfully!";
      fetchCategories();
      deleteModalInstance.hide();
    })
    .catch((error) => console.error("Error deleting category:", error));
};

onMounted(fetchCategories);
</script>

<style scoped>
h2 {
  text-align: left;
  margin-top: 10px;
  font-size: 33px;
  color: white;
}

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
