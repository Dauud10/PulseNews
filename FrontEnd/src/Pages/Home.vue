<template>
  <div class="home">
    <!-- Use NavBar here -->
    <NavBar />

    <img src="@/icons/pulsenews.png" alt="Pulse News Logo" class="logo" />
    <h1>WELCOME TO PULSE NEWS</h1>
    <p>Your daily source of news.</p>
    <SearchBar />
    <div class="cards">
      <Card v-for="article in articles" :key="article.id" :article="article" />
    </div>

    <Footer />
  </div>
</template>

<script>
import NavBar from "@/components/Organisms/NavBar.vue";
import Footer from "@/components/Organisms/Article-Footer.vue";

export default {
  name: "HomePage",
  components: {
    NavBar,
    Footer,
  },
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
            "After some doubts Singer Taylor Swift is able to sing her soul out in the O2 Arena...",
          image: require("@/icons/music.jpg"),
        },
        {
          id: 3,
          title: "BARCELONA VS BAYERN THRILLER",
          description:
            "Bayern got absolutely thrashed 4-1 against their UCL rivals which was a very poor performance by the germans...",
          image: require("@/icons/football.jpg"),
        },
      ],
    };
  },
};
</script>

<style scoped>
.home {
  text-align: center;
  background-color: silver;
  color: black;
  min-height: 100vh;
  padding: 20px;
}

.logo {
  width: 200px;
  height: auto;
  margin-bottom: 20px;
}

.cards {
  display: flex;
  justify-content: space-around;
  gap: 20px;
}

.card img {
  max-width: 100%;
  height: auto;
}
</style>
