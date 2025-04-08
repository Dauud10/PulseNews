import { createRouter, createWebHistory } from "vue-router";
import ArticleDetail from "@/pages/ArticleDetail.vue";
import Home from "@/pages/HomePage.vue";
import Contact from "@/pages/ContactPage.vue";
import AdminDashboard from "@/pages/AdminDashboard.vue";
import Login from "@/pages/LoginPage.vue";
import AdminPage from "@/pages/AdminPage.vue";
import RegisterPage from "@/pages/RegisterPage.vue";
import AdminLogin from "@/pages/AdminLogin.vue";
import CategoryPage from "@/pages/CategoryPage.vue";

const routes = [
  { path: "/", component: Home },
  { path: "/contact", component: Contact },
  { path: "/admin", component: AdminDashboard },
  { path: "/admin-page", component: AdminPage, name: "AdminPage" },
  { path: "/admin login", name: "AdminLogin", component: AdminLogin },
  { path: "/register", name: "Register", component: RegisterPage },
  { path: "/category-page", component: CategoryPage, name: "CategoryPage" },
  {
    path: "/article/:id",
    name: "ArticleDetail",
    component: ArticleDetail,
    props: true,
  },
  { path: "/login", component: Login },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
