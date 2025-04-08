<template>
  <div class="login-page">
    <div class="login-container">
      <img src="@/assets/pulsenews.png" alt="PulseNews Logo" class="logo" />
      <h1>LOG IN TO PULSE NEWS</h1>
      <form @submit.prevent="handleLogin">
        <label for="email">Enter your email:</label>
        <input
          id="email"
          v-model="email"
          type="email"
          placeholder="Enter your email"
          required
        />

        <label for="password">Enter your password:</label>
        <input
          id="password"
          v-model="password"
          type="password"
          placeholder="Enter your password"
          required
        />

        <button type="submit" class="login-button">LOG IN</button>
      </form>
      <p>
        Don't have an account?
        <router-link to="/register" class="register-button"
          >Register</router-link
        >
        >
      </p>
      <p>
        <router-link to="/forgot-password">Forgot password?</router-link>
      </p>
    </div>
  </div>
</template>

<script>
export default {
  name: "LoginPage",
  data() {
    return {
      email: "",
      password: "",
    };
  },
  methods: {
    handleLogin() {
      // Example of login logic (to replace with API call)
      if (this.email && this.password) {
        console.log("Logging in with:", this.email, this.password);
        this.$router.push("/dashboard");
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
  font-size: 24px;
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

router-link {
  color: #ff4242;
  text-decoration: none;
  font-weight: bold;
}

router-link:hover {
  text-decoration: underline;
}
.register-button {
  padding: 10px;
  border: none;
  border-radius: 5px;
  background: #ff4242;
  color: white;
  font-size: 16px;
  cursor: pointer;
  transition: background 0.3s ease;
}
</style>
