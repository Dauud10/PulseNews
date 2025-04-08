<template>
  <footer class="footer bg-black text-white py-4">
    <div class="container">
      <div class="row">
        <!-- Logo & Newsletter -->
        <div class="col-md-3 text-center text-md-start"></div>

        <!-- Donate & Contact Info -->
        <div class="col-md-3 text-left">
          <p>Stay Informed</p>
          <p>Contribute to the news outlet:</p>
          <button class="btn btn-success mb-3">DONATE</button>
        </div>

        <!-- Carbon Footprint & Top Topics -->
        <div class="col-md-3 text-left">
          <p>Useful Links:</p>

          <p><a href="#" class="text-success">Football</a></p>
          <p><a href="#" class="text-success">Global Economy</a></p>
          <p><a href="#" class="text-success">FAQ</a></p>
          <p><a href="#" class="text-success">Sitemap</a></p>
        </div>

        <!-- Legal & Another Donate Button -->
        <div class="col-md-3 text-left">
          <p>Legal:</p>
          <p><a href="#" class="text-success">Imprint</a></p>
          <p><a href="#" class="text-success">Notice to users</a></p>
          <p><a href="#" class="text-success">GTC</a></p>
          <p><a href="#" class="text-success">Data Privacy</a></p>
        </div>
      </div>
    </div>
  </footer>
</template>

<script>
export default {
  name: "FooterComponent",
};
</script>

<style scoped>
.footer {
  border-top: 2px solid green;
}
.logo {
  width: 200px;
  margin-left: -20px;
}
.input-group {
  max-width: 300px;
}
.social-icons i {
  font-size: 1.5rem;
}
.carbon-icons i {
  font-size: 1.2rem;
}
</style>
