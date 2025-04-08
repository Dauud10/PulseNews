<template>
  <header>
    <h1>Admin Dashboard</h1>
  </header>

  <main>
    <div class="container">
      <h2>Welcome!</h2>
      <p>Select an option from the navigation below.</p>
      <router-link to="/CategoryList"
        ><a class="btn">View Category List</a></router-link
      >
      <router-link to="/ArticleList"
        ><a class="btn">View Article List</a></router-link
      >
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
  background-color: #064e3b; /* Dark Green */
  color: black; /* White text for contrast */
}
header {
  background-color: #033d29; /* Darker green for header */
  color: white;
  padding: 1rem 2rem;
  text-align: center;
}
nav {
  background-color: #046c4e; /* Slightly lighter green */
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
  background-color: #cccccc;
}
footer {
  background-color: #033d29;
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
/* Make Welcome message white */
.container h2,
.container p {
  color: black; /* Ensures text remains white */
}
/* Button Styles */
.btn {
  display: inline-block;
  margin: 20px;
  padding: 0.8rem 1.5rem;
  color: white;
  background-color: #198754; /* Red */
  border: none;
  border-radius: 4px;
  text-decoration: none;
  font-size: 1rem;
  transition: background 0.3s ease-in-out;
}
.btn:hover {
  background-color: #1976d2; /* Blue on hover */
}
</style>
<script setup lang="ts"></script>
