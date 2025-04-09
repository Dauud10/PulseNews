<template>
  <div class="contact-page">
    <!-- Hero Section -->
    <section class="hero-section">
      <div class="container text-center text-white">
        <h1>Contact Us</h1>
        <p>
          Have a question? Reach out to us, and we'll get back to you as soon as
          possible.
        </p>
      </div>
    </section>

    <!-- Contact Form & Details Section -->
    <section class="container my-5">
      <div class="content-box">
        <div class="row">
          <!-- Contact Form -->
          <div class="col-md-6">
            <h2>Send Us a Message</h2>
            <form @submit.prevent="submitForm">
              <div class="mb-3">
                <label class="form-label">Your Name</label>
                <input
                  type="text"
                  class="form-control"
                  v-model="name"
                  required
                />
              </div>
              <div class="mb-3">
                <label class="form-label">Your Email</label>
                <input
                  type="email"
                  class="form-control"
                  v-model="email"
                  required
                />
              </div>
              <div class="mb-3">
                <label class="form-label">Your Message</label>
                <textarea
                  class="form-control"
                  v-model="message"
                  rows="4"
                  required
                ></textarea>
              </div>
              <button type="submit" class="btn btn-success w-100">
                Send Message
              </button>
            </form>
          </div>

          <!-- Contact Info -->
          <div class="col-md-6">
            <h2>Contact Information</h2>
            <p>
              <i class="fas fa-map-marker-alt"></i> 123 Pulse Street, Newsville
            </p>
            <p><i class="fas fa-envelope"></i> contact@pulsenews.com</p>
            <p><i class="fas fa-phone"></i> +123 456 7890</p>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
export default {
  name: "ContactUs",
  data() {
    return {
      name: "",
      email: "",
      message: "",
    };
  },
  methods: {
    submitForm() {
      alert(`Thank you, ${this.name}! Your message has been sent.`);
      // Reset form
      this.name = "";
      this.email = "";
      this.message = "";
    },
  },
};
</script>

<style scoped>
/* Hero Section */
.hero-section {
  background: linear-gradient(90deg, #000000 0%, #1a1a1a 100%);
  padding: 80px 20px;
  color: white;
}

.hero-section h1 {
  font-size: 40px;
  font-weight: bold;
  color: white;
}

.hero-section p {
  font-size: 18px;
  color: #dddddd;
}

/* Background Container */
.content-box {
  background: #1a1a1a;
  padding: 40px;
  border-radius: 30px;
  box-shadow: 0px 4px 10px rgba(255, 66, 66, 0.1);
  color: white;
}

/* Contact Info */
p {
  font-size: 18px;
  margin: 10px 0;
  color: #ffffff;
}

i {
  color: #ff4242;
  margin-right: 10px;
}

@media (max-width: 768px) {
  .maps-embed {
    height: 200px;
  }
}
</style>
