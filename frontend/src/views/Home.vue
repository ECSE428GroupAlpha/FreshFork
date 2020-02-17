<script>



export default {
  
  data() {
    return {
    }
  },
  methods:{
    getRecipes(){
      //get recipes from backend
      return [{title: "chicken nodle", rating: 4.9},{title: "chicken nodle", rating: 5.9}]
    }
  },
  computed:{ 
    setRecipeList(){
      return this.getRecipes();
    }
  },
}
// @ is an alias to /src
//import HelloWorld from "@/components/HelloWorld.vue";

//export default {
//  name: "home",
//  components: {
//    HelloWorld
//  }
//};
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
      <img alt="Vue logo" src="../assets/logo.png" />
      <HelloWorld msg="Welcome to Your Vue.js App" />
    </section>
    <section style="margin:auto;">
      <font size="+3">
        Recipes<br>
      </font>
      <section style="float:left">
        <div id="app">
          <div v-for="(recipe, index) in setRecipeList"
            :key="index">

            <div class="button recipe" style="height:100px">
              <div class="card_content">
                <div class="h3" style="font-weight:bold">{{recipe.title}}</div>
                <div class="card_rating" style="color:#42b883;">Rating {{recipe.rating}}</div>
              </div>
            </div>

          </div>
        </div>
      </section>
      <section style="position: absolute; right: 50px">
        <div class="button" style="width:150px;" >Add Recipe</div><br/>
        <div class="button" style="width:150px;">Search Recipes</div>
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