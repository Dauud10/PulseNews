<template>
  <div class="article-detail" v-if="article">
    <h1>{{ article.title }}</h1>
    <p>{{ article.description }}</p>
    <div class="article-content">
      <p>{{ article.content }}</p>
    </div>
    <img :src="article.image" alt="Article Image" class="article-image" />
  </div>
  <div v-else class="loading">
    <p>Loading article...</p>
  </div>
</template>

<script>
export default {
  name: "ArticleDetailPage",
  props: ["id"], // Receiving the article id from the route params
  data() {
    return {
      article: null, // Start with null for dynamic loading
    };
  },
  created() {
    this.fetchArticle();
  },
  methods: {
    fetchArticle() {
      // Replace this with an actual API request, e.g., using axios
      const articles = [
        {
          id: 1,
          title: "NEW DRONES USED IN WAR",
          description:
            "Some new drones have been spotted in the battlefield in Syria and Ukraine...",
          image: require("@/icons/drones.jpg"),
          content: "Full article content here...",
        },
        {
          id: 2,
          title: "ENTERTAINMENT BUZZ",
          description:
            "After some doubts, Singer Taylor Swift is able to sing her soul out in the O2 Arena...",
          image: require("@/icons/music.jpg"),
          content: "Full article content here...",
        },
        // More articles...
      ];

      // Find the article by id
      this.article = articles.find((a) => a.id === parseInt(this.id));

      if (!this.article) {
        this.$router.push({ name: "NotFound" }); // Redirect to a not found page if the article doesn't exist
      }
    },
  },
};
</script>

<style scoped>
.article-detail h1 {
  font-size: 2.5rem;
  margin-bottom: 20px;
}

.article-detail p {
  font-size: 1.1rem;
  line-height: 1.6;
}

.article-detail .article-content {
  margin-top: 20px;
  font-size: 1.1rem;
  line-height: 1.8;
  color: black;
  background-color: white;
}

.article-image {
  max-width: 100%;
  height: auto;
  margin-top: 20px;
  border-radius: 10px;
}

.loading {
  text-align: center;
  font-size: 1.2rem;
  color: #ff4242;
}
</style>
