<template>
  <div class="login">
    <section>
      
      <b-input
        rounded 
        icon="account"
        placeholder="Enter your email"
        v-model="inputEmail"
      ></b-input>

      <b-input
        rounded
        type="password"
        placeholder="Enter your password"
        v-model="inputPassword"
        password-reveal
      ></b-input>

      <b-button 
        class="button"                 
        type="submit" 
        id="loginBtn" 
        rounded
        @click="signInAttempt(inputUsername,inputPassword)"
        >
          Login
      </b-button>

    </section>
  </div>
</template>

<script>
import axios from "axios";
import { REST_ENDPOINT } from "../utils/Util";

export default {
  name: "login",

  data(){
    return{
      inputEmail: '',
      inputPassword: ''

    }
  },

  methods:{
    signInAttempt(inputEmail, inputPassword){
      if(inputEmail == '' || inputPassword == ''){
        this.$buefy.dialog.confirm({
          message: 'Please enter a username and password'});
      }else{
        // this.$buefy.dialog.confirm({
        //   message: 'qwert'});

        axios
          .get(REST_ENDPOINT + "/login", {
            params: {
              email: this.inputEmail,
              password: this.inputPassword
            }
          })
          .then(res => {
            this.res = res.data
            if(res.data != 200){
              this.$buefy.dialog.alert(".then --> error signing in using email "+this.email);
            }else{
              this.$buefy.dialog.alert("success");
            }
          })
          .catch(err => {
            // "invalid email : "+res.data.inputEmail+" and invalid password "+res.data.inputPassword+" try again"
            this.errMsg = err.response.data.message;
            this.$buefy.dialog.alert("Invalid email or password "+this.errMsg+" using email "+this.email);
        }); 
      }
    },

  }


}
</script>

<style>

.login{
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 50%;
}

#loginBtn{
  width: 50%;
}

</style>