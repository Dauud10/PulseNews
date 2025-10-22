<template>
  <div class="about-page">
    <section class="hero-section text-center text-white">
      <div class="container">
        <h1>About PulseNews</h1>
        <p class="herotext">
          PulseNews is your go-to platform for the latest headlines, in-depth
          analysis, and diverse stories that matter.
        </p>
        <p class="herotext">
          From politics and technology to sports and entertainment, we deliver
          up-to-date and reliable news to keep you informed. Our mission is to
          empower the public with knowledge through credible journalism and
          thought-provoking stories.
        </p>
        <hr />
      </div>
    </section>

    <section class="container my-5">
      <div class="content-box">
        <div class="row align-items-center">
          <div class="col-md-6">
            <h2>What We Cover</h2>
            <p>
              PulseNews covers a wide range of topics including global politics,
              warzone updates, entertainment, sports, business, and science.
              Whether it’s breaking news or investigative journalism, we bring
              you the stories that shape our world.
            </p>
          </div>
        </div>
      </div>
    </section>

    <section class="container my-5">
      <div class="content-box">
        <div class="row align-items-center flex-md-row-reverse">
          <div class="col-md-6">
            <h2>Our Mission</h2>
            <p>
              At PulseNews, we aim to be a voice of truth and clarity in an era
              of information overload. Our dedicated team strives to bring
              forward verified, unbiased, and compelling journalism that
              educates and inspires.
            </p>
          </div>
        </div>
      </div>
    </section>

    <div class="cta-section">
      <div class="container text-center">
        <h2 class="cta-title">Stay Informed with PulseNews</h2>
        <p class="cta-text">
          Join thousands of readers who rely on PulseNews daily. Stay updated,
          stay aware.
        </p>
        <button class="btn btn-danger btn-lg" @click="goToCategories">
          Explore Articles
        </button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "AboutUsPage",
  methods: {
    goToCategories() {
      this.$router.push({ name: "ArticleCategories" });
    },
  },
};
</script>

<style scoped>
.about-page {
  background: #1a1a1a;
  color: white;
  min-height: 100vh;
  padding: 20px;
}

.hero-section {
  background: linear-gradient(90deg, #000000 0%, #1a1a1a 100%);
  padding: 40px 20px;
}

.hero-section h1 {
  font-size: 40px;
  font-weight: bold;
}

.hero-section p {
  font-size: 18px;
}

.content-box {
  background: #2a2a2a;
  padding: 40px;
  border-radius: 30px;
  box-shadow: 0px 4px 10px rgba(255, 66, 66, 0.2);
}

p {
  font-size: 18px;
  color: #cccccc;
}

.cta-section {
  background: black;
  color: white;
  padding: 60px 20px;
  text-align: center;
  margin: 50px 0;
  border-radius: 30px;
}

.cta-title {
  font-size: 36px;
  font-weight: bold;
}

.cta-text {
  font-size: 18px;
  margin-bottom: 20px;
  color: #f4f4f4;
}

.herotext {
  color: #f4f4f4;
}

hr {
  margin-top: 50px;
  border-color: #ff4242;
}
</style>
