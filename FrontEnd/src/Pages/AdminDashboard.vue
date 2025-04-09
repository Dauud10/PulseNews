<template>
  <header>
    <h1>Admin Dashboard</h1>
  </header>

  <main>
    <div class="container">
      <h2>Welcome!</h2>
      <p>Select an option from the navigation below.</p>
      <router-link to="/category-list">
        <a class="btn">View Category List</a>
      </router-link>
      <router-link to="/article-list">
        <a class="btn">View Article List</a>
      </router-link>
    </div>
  </main>
</template>

<style scoped>
/* General Styling */
body,
html {
  margin: 0;
  padding: 0;
  font-family: Arial, sans-serif;
  background-color: #141414; /* Dark background for consistency */
  color: white; /* White text for contrast */
}
header {
  background-color: #ff4242; /* Main Red Color for Header */
  color: white;
  padding: 1rem 2rem;
  text-align: center;
}
nav {
  background-color: #ff2a2a; /* Slightly darker red */
  color: white;
  padding: 1rem;
  display: flex;
  justify-content: center;
  gap: 2rem;
}
nav a {
  color: white;
  text-decoration: none;
  font-weight: bold;
}
nav a:hover {
  text-decoration: underline;
}
main {
  padding: 2rem;
  min-height: calc(100vh - 120px);
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #222222; /* Dark background for main area */
}
footer {
  background-color: #033d29; /* Dark Green Footer */
  color: white;
  text-align: center;
  padding: 1rem;
  position: relative;
}
.container {
  max-width: 1000px;
  margin: 0 auto;
  text-align: center;
}
.container h2,
.container p {
  color: white; /* Ensures text remains readable */
}

/* Button Styles */
.btn {
  display: inline-block;
  margin: 20px;
  padding: 0.8rem 1.5rem;
  color: white;
  background-color: #ff4242; /* Button matching main red color */
  border: none;
  border-radius: 4px;
  text-decoration: none;
  font-size: 1rem;
  transition: background 0.3s ease-in-out;
}
.btn:hover {
  background-color: #d93636; /* Slightly darker red for hover */
}
</style>

<script setup lang="ts"></script>
