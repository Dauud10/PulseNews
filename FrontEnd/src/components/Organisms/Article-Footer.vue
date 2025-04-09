<template>
  <footer class="footer">
    <div class="container">
      <div class="row">
        <!-- Logo & Newsletter -->
        <div class="col-md-3 text-center text-md-start">
          <!-- Optional logo or newsletter content here -->
        </div>

        <!-- Donate & Contact Info -->
        <div class="col-md-3 text-left">
          <p class="footer-text">Stay Informed</p>
          <p class="footer-text">Support journalism:</p>
          <button class="btn btn-donate mb-3">DONATE</button>
        </div>

        <!-- Article Categories Links -->
        <div class="col-md-3 text-left">
          <p class="footer-text">Article Categories:</p>
          <p><a href="/politics" class="footer-link">Politics</a></p>
          <p><a href="/technology" class="footer-link">Technology</a></p>
          <p><a href="/business" class="footer-link">Business</a></p>
          <p><a href="/lifestyle" class="footer-link">Lifestyle</a></p>
        </div>

        <!-- Useful Resources -->
        <div class="col-md-3 text-left">
          <p class="footer-text">Useful Resources:</p>
          <p><a href="/faq" class="footer-link">FAQ</a></p>
          <p><a href="/sitemap" class="footer-link">Sitemap</a></p>
          <p><a href="/about-us" class="footer-link">About Us</a></p>
          <p><a href="/contact-us" class="footer-link">Contact Us</a></p>
        </div>

        <!-- Legal -->
        <div class="col-md-3 text-left">
          <p class="footer-text">Legal:</p>
          <p><a href="/imprint" class="footer-link">Imprint</a></p>
          <p>
            <a href="/terms-and-conditions" class="footer-link"
              >Terms & Conditions</a
            >
          </p>
          <p>
            <a href="/privacy-policy" class="footer-link">Privacy Policy</a>
          </p>
          <p><a href="/cookie-policy" class="footer-link">Cookie Policy</a></p>
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
  background-color: #222; /* Dark Gray for consistency */
  color: white;
  border-top: 2px solid #ff4242; /* Red border */
  padding: 1rem 2rem; /* Match navbar padding */
}

.footer-text {
  color: white;
  font-size: 1rem; /* Match navbar font size */
  margin-bottom: 0.5rem;
}

.footer-link {
  color: #ff4242; /* Red color for links */
  text-decoration: none;
  font-size: 1rem; /* Match navbar font size */
}

.footer-link:hover {
  text-decoration: underline;
}

.btn-donate {
  background-color: #ff4242; /* Red button */
  color: white;
  border: none;
  border-radius: 5px;
  padding: 10px 20px;
  font-size: 1rem;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.btn-donate:hover {
  background-color: #d93636; /* Darker red on hover */
}

/* Ensure text and links are legible on smaller screens */
@media (max-width: 768px) {
  .footer {
    padding: 1.5rem 1rem; /* Adjust padding for smaller screens */
  }

  .footer-text,
  .footer-link {
    font-size: 0.9rem; /* Slightly smaller font size for mobile */
  }
}
</style>
