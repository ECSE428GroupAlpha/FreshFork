<script>
import axios from "axios";
import { REST_ENDPOINT } from "../utils/Util";

export default {
  name: "listRecipes",
  data() {
    return {
      recipes : []
    };
  },
  methods: {
    getRecipes() {
    // Initializing people from backend
    axios.get(REST_ENDPOINT + "/recipe/list")
      .then(response => {
        // JSON responses are automatically parsed.
        this.recipes = response.data
      })
      .catch(err => {
        this.$buefy.dialog.alert(err.response.data.message);
      })
    },
    addRecipe(){
      this.recipes.push({recipeName: "a", steps: "a", rating: 2.0})
    }
  }
};
</script>

<template>
  <div class="home">
    
    <section>
      <div class="button" style="width:100px; position: absolute; right: 100px">Profile</div>
      <p style="margin-bottom:10px">
        <font size="+5">
          <b>Home</b>
        </font>
      </p>
      <img alt="Vue logo" src="../assets/freshForkLogo.png" />
      <HelloWorld msg="Welcome to Your Vue.js App" />
    </section>
    <section style="margin:auto;">
      <font size="+3">
        Recipes<br>
      </font>
      <section style="float:left">
        <div id="app">
          <div v-for="(recipe, index) in recipes"
            :key="index">

            <div class="button recipe" style="height:100px">
              <div class="card_content">
                <div class="h3" style="font-weight:bold">{{recipe.recipeName}}</div>
                <div class="card_rating" style="color:#42b883;">Rating {{recipe.rating}}</div>
              </div>
            </div>

          </div>
        </div>
      </section>
      <section style="position: absolute; right: 50px">
        <div class="button" style="width:150px;" @click="addRecipe">Add Recipe</div><br/>
        <div class="button" style="width:150px;" @click="getRecipes">Search Recipes</div>
      </section>
    </section>
  </div>
</template>






<style lang="scss">
@import "../styles/variables.scss";
.card {
  height: 160px;
  width: 450px;
  background-color: lightgreen;
  padding: 10px;
  margin-bottom: 10px;
}

.recipe {
  width: 550px;
  height: 100px;
}

.card__content {
  display: inline-block;
  padding: 20px;
  position: relative;
  text-align: left;
  vertical-align: top;
  width: calc(100% - 500px);
  height: 20px;
}

.card__content h3 {
  margin: 0;
  font-weight: bold;
}

.card__rating {
  position: absolute;
  bottom: 10px;
  color: #42b883;
}

</style>