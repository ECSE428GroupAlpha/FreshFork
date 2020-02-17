<template>
<div class="container">
  <h1> register </h1>
  <hr>
  <div class="row">
  <div class="col-md-3">
    
  </div>
    <div class="col-md-3">
  <div class="form-group">
    <label for="username">Username</label>
    <input type="text" class="form-control" id="username" v-model="username" required placeholder="Username">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="password" v-model="password" required placeholder="Password">
  </div>
  <div v-if="password.length >1 && password.length <6 " class="text-danger">
    password length should be greater than 6
  </div>

    <div class="form-group">
    <input type="password" class="form-control" id="reenterpassword" v-model="reenterpassword" required placeholder="Enter the same password">
  </div>
<div v-if="password != reenterpassword" class="text-danger">
password doesn't match
  </div>
<br>
  <button type="submit" class="btn btn-primary">Submit</button>
  </div>
    <div class="col-md-3">
    
  </div>
  </div>
</div>
</template>

<script>
export default {
  name:"register",
  data(){
    return{
      username:"",
      password:"",
      reenterpassword:""
    }
  },
  methods:{
    register:function(){
      console.log("Username "+ this.username);
    }
  }
};
</script>

<style scoped>
</style>
