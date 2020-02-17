<template>
  <div class="container">
    <h1>Login</h1>
    <hr>
    <div class="row">
      <div class="col-md-3"></div>
      <div class="col-md-3">
        <div class="form-group">
          <label for="username">Username</label>
          <input
            type="text"
            class="form-control"
            id="username"
            v-model="username"
            required
            placeholder="Username"
          >
        </div>
        <div class="form-group">
          <label for="exampleInputPassword1">Password</label>
          <input
            type="password"
            class="form-control"
            id="password"
            v-model="password"
            required
            placeholder="Password"
          >
        </div>

        <br>
        <button type="submit" class="btn btn-primary">Submit</button>
      </div>
      <div class="col-md-3"></div>
    </div>
  </div>
</template>

<script>
export default {
  name: "login",
  data() {
    return {
      username: "",
      password: ""
    };
  },
  methods: {
    register: function() {
      console.log("Username " + this.username);
      console.log("password " + this.password);
    }
  }
};
</script>

<style scoped>
</style>
