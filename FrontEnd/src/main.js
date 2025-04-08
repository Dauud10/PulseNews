import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle.min.js";
import { createApp } from "vue";
import App from "./App.vue";
import router from "./router"; // Import the router

createApp(App)
  .use(router) // Make sure to use the router here
  .mount("#app");
