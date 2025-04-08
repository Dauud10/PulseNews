<template>
  <div id="app">
    <!-- Use NavBar here -->
    <NavBar />
    <router-view />
    <Footer />
  </div>
</template>

<script>
import NavBar from "./components/Organisms/NavBar.vue"; // Make sure the path is correct
import Footer from "./components/Organisms/SiteFooter.vue";

export default {
  name: "App",
  components: {
    NavBar, // Ensure NavBar is properly registered
    Footer,
  },
};
</script>

<style>
/* Ensure the app uses flexbox to properly layout the footer */
#app {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
  background: linear-gradient(90deg, #0097b2 0%, #349610 73%);
}

body {
  margin: 0;
}

/* router-view (main content) grows to fill space between header and footer */
router-view {
  flex: 1;
}
</style>
