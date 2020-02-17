<template>
  <div class="createRecipe">
    <section>
      <b-field label="Name">
        <b-input v-model="name"></b-input>
      </b-field>
      <b-field label="Steps">
        <b-input v-model="steps" type="textarea"></b-input>
      </b-field>

      <b-field label="Rating">
        <b-rate v-model="rating"></b-rate>
      </b-field>

      <p class="errMsg" v-if="errMsg !== ''">{{this.errMsg}}</p>
      <div class="button" style="width:100%" @click="createRecipe">Create Recipe</div>
    </section>
  </div>
</template>

<script>
import axios from "axios";
import { REST_ENDPOINT } from "../utils/Util";

export default {
  name: "createRecipe",
  data() {
    return {
      authorID: 12312412,
      name: "",
      steps: "",
      rating: 0,
      errMsg: ""
    };
  },
  methods: {
    createRecipe() {
      axios
        .post(REST_ENDPOINT + "/users/createRecipe", null, {
          params: {
            authorID: this.authorID,
            recipename: this.name,
            steps: this.steps,
            rating: this.rating.toString()
          }
        })
        .then(res =>
          this.$buefy.dialog.alert(
            "Recipe " + res.data.recipeName + " created succesfully"
          )
        )
        .catch(err => {
          this.errMsg = err.response.data.message;
        });
    }
  }
};
</script>

<style lang="scss">
@import "../styles/variables.scss";

.createRecipe {
  max-width: 800px;
  margin: auto;
  text-align: left;
  padding: 20px;
}

.question {
  margin-bottom: 30px;
}

.errMsg {
  color: red;
}
</style>
