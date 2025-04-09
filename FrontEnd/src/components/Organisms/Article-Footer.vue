<template>
  <footer class="footer">
    <div class="container">
      <div class="footer-grid">
        <!-- Support & Donate -->
        <div class="footer-section">
          <p class="footer-heading">Stay Informed</p>
          <p>Support journalism:</p>
          <button class="btn-donate">DONATE</button>
        </div>

        <!-- Categories -->
        <div class="footer-section">
          <p class="footer-heading">Article Categories</p>
          <ul>
            <li><a href="/politics" class="footer-link">Politics</a></li>
            <li><a href="/technology" class="footer-link">Technology</a></li>
            <li><a href="/business" class="footer-link">Business</a></li>
            <li><a href="/lifestyle" class="footer-link">Lifestyle</a></li>
          </ul>
        </div>

        <!-- Resources -->
        <div class="footer-section">
          <p class="footer-heading">Useful Resources</p>
          <ul>
            <li><a href="/faq" class="footer-link">FAQ</a></li>
            <li><a href="/sitemap" class="footer-link">Sitemap</a></li>
            <li><a href="/about-us" class="footer-link">About Us</a></li>
            <li><a href="/contact-us" class="footer-link">Contact Us</a></li>
          </ul>
        </div>

        <!-- Legal -->
        <div class="footer-section">
          <p class="footer-heading">Legal</p>
          <ul>
            <li><a href="/imprint" class="footer-link">Imprint</a></li>
            <li>
              <a href="/terms-and-conditions" class="footer-link"
                >Terms & Conditions</a
              >
            </li>
            <li>
              <a href="/privacy-policy" class="footer-link">Privacy Policy</a>
            </li>
            <li>
              <a href="/cookie-policy" class="footer-link">Cookie Policy</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </footer>
</template>

<script>
export default {
  name: "ArticleFooter",
};
</script>

<style scoped>
.footer {
  background-color: #222;
  color: white;
  border-top: 2px solid #ff4242;
  padding: 2rem 1rem;
}

.footer-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
  gap: 2rem;
}

.footer-section {
  display: flex;
  flex-direction: column;
}

.footer-heading {
  color: #ff4242;
  font-weight: bold;
  margin-bottom: 0.5rem;
  font-size: 1.1rem;
}

.footer-link {
  color: #ff4242;
  text-decoration: none;
  font-size: 0.95rem;
  margin-bottom: 0.3rem;
}

.footer-link:hover {
  text-decoration: underline;
}

.btn-donate {
  background-color: #ff4242;
  color: white;
  border: none;
  border-radius: 5px;
  padding: 8px 16px;
  margin-top: 10px;
  font-size: 0.95rem;
  cursor: pointer;
  width: fit-content;
  transition: background-color 0.3s ease;
}

.btn-donate:hover {
  background-color: #d93636;
}

@media (max-width: 768px) {
  .footer {
    padding: 1.5rem 1rem;
  }

  .footer-link {
    font-size: 0.9rem;
  }
}
</style>
