<template>
  <div class="home">
    <!-- Hero Section -->
    <section class="hero text-center">
      <img src="@/icons/pulsenews.png" alt="Pulse News Logo" class="logo" />
      <h1>WELCOME TO PULSE NEWS</h1>
      <p class="subtitle">Your daily source of news.</p>
    </section>

    <!-- Articles Section -->
    <section class="articles-section container">
      <h2 class="section-title">Top Stories</h2>
      <div class="row">
        <div
          class="col-md-4 mb-4"
          v-for="article in articles"
          :key="article.id"
        >
          <div class="card h-100">
            <img
              :src="article.image"
              class="card-img-top"
              alt="Article Image"
            />
            <div class="card-body">
              <h5 class="card-title">{{ article.title }}</h5>
              <p class="card-text">{{ article.description }}</p>
              <router-link ref="/" class="btn btn-danger" to="">
                Read More
              </router-link>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- CTA Section -->
    <section class="cta-section">
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
    </section>
  </div>
</template>

<script>
export default {
  name: "HomePage",
  data() {
    return {
      articles: [
        {
          id: 1,
          title: "NEW DRONES USED IN WAR",
          description:
            "Some new drones have been spotted in the battlefield in Syria and Ukraine...",
          image: require("@/icons/drones.jpg"),
        },
        {
          id: 2,
          title: "ENTERTAINMENT BUZZ",
          description:
            "After some doubts, singer Taylor Swift is able to sing her soul out in the O2 Arena...",
          image: require("@/icons/music.jpg"),
        },
        {
          id: 3,
          title: "BARCELONA VS BAYERN THRILLER",
          description:
            "Bayern got absolutely thrashed 4-1 against their UCL rivals which was a very poor performance by the Germans...",
          image: require("@/icons/football.jpg"),
        },
      ],
    };
  },
  methods: {
    goToCategories() {
      this.$router.push({ name: "ArticleCategories" });
    },
  },
};
</script>

<style scoped>
.home {
  background: #1a1a1a;
  color: white;
  min-height: 100vh;
  padding: 20px;
}

.logo {
  width: 180px;
  height: auto;
  margin-bottom: 20px;
}

.subtitle {
  font-size: 1.2rem;
  color: #cccccc;
}

.section-title {
  font-size: 2rem;
  margin: 40px 0 20px;
  color: #ff4242;
  text-align: center;
}

.card {
  background-color: #2a2a2a;
  color: white;
  border: none;
  border-radius: 12px;
  box-shadow: 0 0 10px rgba(255, 66, 66, 0.2);
}

.card-img-top {
  height: 200px;
  object-fit: cover;
  border-top-left-radius: 12px;
  border-top-right-radius: 12px;
}

.card-title {
  color: #ff4242;
  font-weight: bold;
}

.btn-danger {
  background-color: #ff4242;
  border: none;
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

hr {
  margin-top: 50px;
  border-color: #ff4242;
}
</style>
