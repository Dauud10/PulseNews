<template>
  <div class="login-page">
    <div class="login-container">
      <img src="@/icons/pulsenews.png" alt="PulseNews Logo" class="logo" />
      <h1>ADMIN LOGIN - PULSE NEWS</h1>
      <form @submit.prevent="handleAdminLogin">
        <label for="email">Enter your admin email:</label>
        <input
          id="email"
          v-model="email"
          type="email"
          placeholder="Enter your email"
          required
        />

        <label for="password">Enter your admin password:</label>
        <input
          id="password"
          v-model="password"
          type="password"
          placeholder="Enter your password"
          required
        />

        <button type="submit" class="login-button">ADMIN LOGIN</button>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: "AdminLogin",
  data() {
    return {
      email: "",
      password: "",
    };
  },
  methods: {
    handleAdminLogin() {
      if (this.email && this.password) {
        console.log("Admin logging in:", this.email);
        this.$router.push("/admin-dashboard"); // Correct path to AdminDashboard
      } else {
        alert("Please fill out all fields.");
      }
    },
  },
};
</script>

<style scoped>
.login-page {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #141414;
}

.login-container {
  text-align: center;
  background: #222;
  padding: 30px 20px;
  border-radius: 10px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.5);
  color: #fff;
  width: 350px;
}

.logo {
  width: 120px;
  margin-bottom: 20px;
}

h1 {
  font-size: 22px;
  margin-bottom: 20px;
  color: #ff4242;
}

form {
  display: flex;
  flex-direction: column;
  gap: 15px;
}

label {
  font-size: 14px;
  text-align: left;
}

input {
  padding: 10px;
  border: 1px solid #444;
  border-radius: 5px;
  background: #333;
  color: #fff;
  font-size: 16px;
}

input::placeholder {
  color: #aaa;
}

input:focus {
  outline: none;
  border-color: #ff4242;
}

.login-button {
  padding: 10px;
  border: none;
  border-radius: 5px;
  background: #ff4242;
  color: white;
  font-size: 16px;
  cursor: pointer;
  transition: background 0.3s ease;
}

.login-button:hover {
  background: #d93636;
}
</style>
