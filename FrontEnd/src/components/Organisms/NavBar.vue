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
        to="/article-detail"
        class="nav-link"
        exact-active-class="active"
        >ARTICLE DETAIL</router-link
      >
      <router-link
        to="/articlecategories"
        class="nav-link"
        exact-active-class="active"
        >CATEGORIES</router-link
      >
      <router-link to="/contact-us" class="nav-link" exact-active-class="active"
        >CONTACT</router-link
      >
    </nav>

    <!-- Search Bar and User Actions -->
    <div class="actions">
      <div class="search-container">
        <input
          type="text"
          v-model="searchQuery"
          placeholder="Search"
          class="search-bar"
          @keypress.enter="performSearch"
        />
      </div>
      <router-link to="/login" class="nav-link" exact-active-class="active"
        >LOG IN</router-link
      >
    </div>

    <!-- Mobile Menu Toggle -->
    <button class="menu-toggle" @click="toggleMobileMenu">
      <i class="fas fa-bars"></i>
    </button>

    <!-- Mobile Menu -->
    <div class="mobile-menu" v-if="isMobileMenuOpen">
      <router-link to="/" class="nav-link" @click="toggleMobileMenu"
        >HOME</router-link
      >
      <router-link
        to="/articlecategories"
        class="nav-link"
        @click="toggleMobileMenu"
        >CATEGORIES</router-link
      >
      <router-link to="/contact" class="nav-link" @click="toggleMobileMenu"
        >CONTACT</router-link
      >
      <router-link to="/login" class="nav-link" @click="toggleMobileMenu"
        >LOGIN</router-link
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
    };
  },
  setup() {
    useRouter();
    const performSearch = () => {
      // Implement search logic here if needed
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
/* General Styling */
.pulse-header {
  background-color: black;
  color: white;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 1rem 2rem;
}

.nav-links {
  display: flex;
  gap: 1.5rem;
}

.nav-link {
  color: white;
  text-decoration: none;
  font-size: 1rem;
  font-weight: bold;
  transition: color 0.3s ease;
}

.nav-link:hover,
.nav-link.active {
  color: #ff4242; /* Red color on hover */
}

.actions {
  display: flex;
  align-items: center;
  gap: 1rem;
}

.search-bar {
  padding: 0.5rem;
  border-radius: 5px;
  border: 1px solid #444;
  background-color: #333;
  color: white;
}

.search-bar:focus {
  outline: none;
  border-color: #ff4242;
}

.menu-toggle {
  background: none;
  border: none;
  color: white;
  font-size: 1.5rem;
  cursor: pointer;
  display: none;
}

.mobile-menu {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  background-color: black;
  color: white;
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 2rem;
  gap: 1rem;
  z-index: 100;
}

@media (max-width: 768px) {
  .menu-toggle {
    display: block;
  }

  .nav-links {
    display: none;
  }

  .mobile-menu {
    display: flex;
  }
}
</style>
