<template>
  <header class="pulse-header">
    <!-- Logo -->
    <pulse-logo />

    <!-- Navigation Links -->
    <nav class="nav-links">
      <router-link to="/" class="nav-link" exact-active-class="active"
        >HOME</router-link
      >
      <router-link to="/" class="nav-link" exact-active-class="active"
        >ARTICLE DETAIL</router-link
      >
      <router-link to="/categories" class="nav-link" exact-active-class="active"
        >CATEGORIES</router-link
      >
      <router-link
        to="/contactpage"
        class="nav-link"
        exact-active-class="active"
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
      <router-link to="/registerpage" class="user-icon">
        <user-icon />
      </router-link>
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
      <router-link to="/about" class="nav-link" @click="toggleMobileMenu"
        >ABOUT</router-link
      >
      <router-link
        to="/usercategories"
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
      if (this.searchQuery.trim() !== "") {
      }
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
/* Header Styling */
.pulse-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: black;
  padding: 15px 20px;
  color: white;
  position: relative;
  margin: 0;
}

/* Navigation Links */
.nav-links {
  display: flex;
  gap: 30px;
}

.nav-link {
  color: white;
  text-decoration: none;
  font-weight: bold;
  font-size: 16px;
  transition: 0.3s;
}

.nav-link:hover,
.nav-link.active {
  color: #2fa169;
}

/* Actions (Search + User) */
.actions {
  display: flex;
  align-items: center;
  gap: 10px;
}

/* Search Bar */
.search-container {
  display: flex;
  align-items: center;
}

.search-bar {
  padding: 8px 15px;
  border-radius: 5px;
  border: none;
  font-size: 14px;
  width: 200px;
}

.search-btn {
  background: green;
  border: none;
  padding: 8px 10px;
  color: white;
  cursor: pointer;
  border-radius: 5px;
}

.user-icon {
  width: 40px;
  height: 40px;
  display: flex;
  justify-content: center;
  align-items: center;
  cursor: pointer;
}

.login-link {
  color: white;
  text-decoration: none;
  font-size: 16px;
  font-weight: bold;
}

/* Mobile Menu */
.menu-toggle {
  display: none;
  background: none;
  border: none;
  color: white;
  font-size: 24px;
  cursor: pointer;
}

.mobile-menu {
  display: none;
  position: absolute;
  top: 60px;
  right: 0;
  background: black;
  width: 100%;
  text-align: center;
  flex-direction: column;
  gap: 15px;
  padding: 20px;
}

.mobile-menu .nav-link {
  display: block;
  padding: 10px;
}

/* Responsive Design */
@media (max-width: 768px) {
  .nav-links {
    display: none;
  }

  .menu-toggle {
    display: block;
  }

  .mobile-menu {
    display: flex;
  }
}
</style>

<style scoped>
nav {
  background-color: #333;
  padding: 10px 0;
}

ul {
  list-style: none;
  display: flex;
  justify-content: center;
}

li {
  margin: 0 15px;
}

a {
  color: white;
  text-decoration: none;
}
</style>
