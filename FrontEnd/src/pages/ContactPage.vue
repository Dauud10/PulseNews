<template>
  <div class="contact">
    <h1>Contact Us</h1>
    <form>
      <label for="name">Your Name</label>
      <input type="text" id="name" placeholder="Enter your name" />

      <label for="message">Your Message</label>
      <textarea id="message" placeholder="Enter your message"></textarea>

      <button type="submit">Submit</button>
    </form>
  </div>
</template>

<script>
export default {
  name: "ContactPage",
};
</script>

<style scoped>
.contact {
  background-color: red;
  color: black;
  padding: 20px;
  min-height: 100vh;
}

form {
  display: flex;
  flex-direction: column;
  gap: 10px;
}

button {
  background-color: #008cba;
  color: white;
  padding: 10px;
  border: none;
  cursor: pointer;
}
</style>
