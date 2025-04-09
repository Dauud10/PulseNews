<template>
  <header class="pulse-header">
    <!-- Logo -->
    <pulse-logo />

    <!-- Navigation Links -->
    <nav class="nav-links">
      <router-link to="/" class="nav-link" exact-active-class="active"
        >HOME</router-link
      >
      <router-link
        to="/articlecategories"
        class="nav-link"
        exact-active-class="active"
        >CATEGORIES</router-link
      >
      <router-link to="/contact-us" class="nav-link" exact-active-class="active"
        >CONTACT US</router-link
      >
    </nav>

    <!-- Search Bar and Log In -->
    <div class="actions">
      <input
        type="text"
        v-model="searchQuery"
        placeholder="Search"
        class="search-bar"
        @keypress.enter="performSearch"
      />
      <router-link
        to="/login"
        class="nav-link login-link"
        exact-active-class="active"
        >LOG IN</router-link
      >
    </div>

    <!-- Mobile Toggle -->
    <button class="menu-toggle" @click="toggleMobileMenu">
      <i class="fas fa-bars"></i>
    </button>

    <!-- Mobile Menu -->
    <div class="mobile-menu" v-if="isMobileMenuOpen">
      <router-link to="/" class="nav-link" @click="toggleMobileMenu"
        >HOME</router-link
      >
      <router-link
        to="/article-detail"
        class="nav-link"
        @click="toggleMobileMenu"
        >ARTICLE DETAIL</router-link
      >
      <router-link
        to="/articlecategories"
        class="nav-link"
        @click="toggleMobileMenu"
        >CATEGORIES</router-link
      >
      <router-link to="/contact-us" class="nav-link" @click="toggleMobileMenu"
        >CONTACT</router-link
      >
      <router-link to="/login" class="nav-link" @click="toggleMobileMenu"
        >LOG IN</router-link
      >
    </div>
  </header>
</template>

<script>
import { useRouter } from "vue-router";
import PulseLogo from "@/components/Atoms/PulseLogo.vue";

export default {
  name: "NavBar",
  components: { PulseLogo },
  data() {
    return {
      isMobileMenuOpen: false,
      searchQuery: "",
    };
  },
  setup() {
    useRouter();
    const performSearch = () => {
      // Add search logic if needed
    };

    return { performSearch };
  },
  methods: {
    toggleMobileMenu() {
      this.isMobileMenuOpen = !this.isMobileMenuOpen;
    },
  },
};
</script>

<style scoped>
.pulse-header {
  background-color: #222;
  color: white;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 1rem 2rem;
  flex-wrap: wrap;
  border-bottom: 2px solid #ff4242;
}

.nav-links {
  display: flex;
  gap: 1.5rem;
  flex-wrap: wrap;
}

.nav-link {
  color: white;
  text-decoration: none;
  font-weight: bold;
  font-size: 1rem;
  transition: color 0.3s ease;
}

.nav-link:hover,
.nav-link.active {
  color: #ff4242;
}

.login-link {
  font-weight: bold;
}

.actions {
  display: flex;
  align-items: center;
  gap: 1rem;
  flex-wrap: wrap;
}

.search-bar {
  background-color: #333;
  color: white;
  border: 1px solid #444;
  border-radius: 5px;
  padding: 0.5rem 0.75rem;
  transition: border-color 0.3s ease;
}

.search-bar:focus {
  outline: none;
  border-color: #ff4242;
}

.menu-toggle {
  display: none;
  background: none;
  border: none;
  color: white;
  font-size: 1.5rem;
  cursor: pointer;
}

.mobile-menu {
  width: 100%;
  background-color: #111;
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 1.5rem 0;
  gap: 1rem;
  border-top: 1px solid #333;
}

/* Responsive */
@media (max-width: 768px) {
  .nav-links,
  .actions {
    display: none;
  }

  .menu-toggle {
    display: block;
  }
}
</style>
