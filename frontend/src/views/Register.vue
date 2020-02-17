<template>
<div class="container">
  <h1> register </h1>
  <hr>
  <div class="row">
  <div class="col-md-3">
    
  </div>
    <div class="col-md-3">
  <div class="form-group">
    <label for="name">Name</label>
    <input type="text" class="form-control" id="name" v-model="name" required placeholder="Name">
  </div>
  <div class="form-group">
    <label for="email">Email</label>
    <input type="text" class="form-control" id="email" v-model="email" required placeholder="Email">
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
  </div>
<br>
  <button type="submit" class="btn btn-primary" @click="register">Submit</button>
  </div>
    <div class="col-md-3">
    
  </div>
  </div>
</div>
</template>

<script>
import axios from "axios";
import { REST_ENDPOINT } from "../utils/Util";

export default {
  name: "register",

  data(){
    return{
      name: '',
      email: '',
      password: '',
      reenterpassword: '',
      isPro: true
    }
  },

  methods:{
    register(){
      if(this.email == '' || this.password == '' || this.reenterpassword == ''){
        this.$buefy.dialog.confirm({
          message: 'All fields must be filled.'});
      }
      else if(this.password != this.reenterpassword){
        this.$buefy.dialog.confirm({
          message: 'Passwords must match'});
      }
      else{
        // this.$buefy.dialog.confirm({
        //   message: 'qwert'});

        axios
          .post(REST_ENDPOINT + "/users/create", null,{
            params: {
              name: this.name,
              password: this.password,
              email: this.email,
              isPro: this.isPro
            }
          })
          .then(res => {
              this.$buefy.dialog.alert("User with ID "+res.data.uid+" created");
          })
          .catch(err => {
            // "invalid email : "+res.data.inputEmail+" and invalid password "+res.data.inputPassword+" try again"
            this.errMsg = err.response.data.message;
            this.$buefy.dialog.alert(this.errMsg);
        }); 
      }
    },

  }
}
</script>

<style scoped>
</style>
