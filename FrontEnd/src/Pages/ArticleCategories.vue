<template>
  <h1>Choose Article</h1>
  <div class="categories">Categories</div>
  <div class="image-container">
    <router-link to="@/pages/article detail"
      ><img src="image1.jpg" alt="Category 1"
    /></router-link>
    <img src="image2.jpg" alt="Category 2" />
    <img src="image3.jpg" alt="Category 3" />
  </div>
</template>

<style scoped>
body {
  font-family: Arial, sans-serif;
  margin: 0;
  padding: 0;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
  background-color: #f4f4f4;
}
h1 {
  text-align: center;
  margin-top: 10px;
  font-size: 20px;
  color: white;
}
.categories {
  text-align: center;
  margin-top: 10px;
  font-size: 20px;
  color: white;
}
.image-container {
  display: flex;
  justify-content: center;
  margin-top: 20px;
}
.image-container img {
  width: 150px;
  height: 150px;
  margin: 0 10px;
  border-radius: 10px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}
</style>
