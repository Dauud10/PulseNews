import { createRouter, createWebHistory } from "vue-router";
import Home from "@/Pages/Home.vue";
import RegisterPage from "@/Pages/RegisterPage.vue";
import CategoryList from "@/Pages/CategoryList.vue";
import CategoryForm from "@/Pages/CategoryForm.vue";
import LoginPage from "@/Pages/LoginPage.vue";
import AdminLogin from "@/Pages/AdminLogin.vue";
import AdminDashboard from "@/Pages/AdminDashboard.vue";
import ArticleList from "@/Pages/ArticleList.vue";
import ArticleForm from "@/Pages/ArticleForm.vue";
import ContactUs from "@/Pages/ContactUs.vue";
import ArticleCategories from "@/Pages/ArticleCategories.vue";
import ArticleDetailPage from "@/Pages/ArticleDetail.vue"; // Import ArticleDetailPage

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home, // Default route, showing Home page
  },
  {
    path: "/contact-us",
    name: "Contact",
    component: ContactUs,
  },
  {
    path: "/adminlogin",
    name: "AdminLogin", // Ensure you name the route
    component: AdminLogin,
  },
  {
    path: "/admin-dashboard",
    name: "AdminDashboard",
    component: AdminDashboard,
  },
  {
    path: "/category-list",
    name: "CategoryList",
    component: CategoryList,
  },
  {
    path: "/register",
    name: "Register",
    component: RegisterPage,
  },
  {
    path: "/articlecategories",
    name: "ArticleCategories",
    component: ArticleCategories,
  },
  {
    path: "/login",
    name: "Login",
    component: LoginPage,
  },
  {
    path: "/article-list",
    name: "ArticleList",
    component: ArticleList,
  },
  {
    path: "/article-form",
    name: "ArticleForm",
    component: ArticleForm,
  },
  {
    path: "/add-article",
    name: "AddArticle",
    component: ArticleForm,
  },
  {
    path: "/edit-article/:id",
    name: "EditArticle",
    component: ArticleForm,
    props: true, // Passing dynamic parameter (id) as prop
  },
  {
    path: "/article/:id", // New route for Article Detail Page
    name: "ArticleDetail", // Ensure the name is unique
    component: ArticleDetailPage,
    props: true, // Passing dynamic parameter (id) as prop
  },
  {
    path: "/add-category",
    name: "AddCategory",
    component: CategoryForm,
  },
  {
    path: "/edit-category/:id",
    name: "EditCategory",
    component: CategoryForm,
    props: true, // Passing dynamic parameter (id) as prop
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
