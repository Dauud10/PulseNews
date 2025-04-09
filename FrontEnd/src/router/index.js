import { createRouter, createWebHistory } from "vue-router";

import Home from "@/Pages/HomePage.vue";
import AboutUsPage from "@/Pages/AboutUsPage.vue";
import ArticleCategories from "@/Pages/ArticleCategories.vue";
import ContactUs from "@/Pages/ContactUsPage.vue";

import LoginPage from "@/Pages/LoginPage.vue";
import AdminLogin from "@/Pages/AdminLoginPage.vue";
import RegisterPage from "@/Pages/RegisterPage.vue";

import AdminDashboard from "@/Pages/AdminDashboard.vue";
import CategoryList from "@/Pages/CategoryList.vue";
import CategoryForm from "@/Pages/CategoryForm.vue";
import ArticleList from "@/Pages/ArticleList.vue";
import ArticleForm from "@/Pages/ArticleForm.vue";

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/aboutus",
    name: "AboutUs",
    component: AboutUsPage,
  },

  {
    path: "/articlecategories",
    name: "ArticleCategories",
    component: ArticleCategories,
  },
  {
    path: "/contact-us",
    name: "Contact",
    component: ContactUs,
  },

  {
    path: "/login",
    name: "Login",
    component: LoginPage,
  },
  {
    path: "/register",
    name: "Register",
    component: RegisterPage,
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
