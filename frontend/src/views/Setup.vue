<template>
  <div class="setup">
    <section>
      <p style="margin-bottom:10px">
        <b>Select a Diet</b>
      </p>
      <b-field>
        <div class="diets question">
          <b-radio-button
            v-model="dietSelection"
            :native-value="diet"
            v-for="(diet, index) in diets"
            v-bind:key="index"
            type="is-primary"
          >{{diet}}</b-radio-button>
        </div>
      </b-field>

      <p style="margin-bottom:10px">
        <b>Ingredients to exclude (allergies, don't like etc.)</b>
      </p>
      <b-autocomplete
        rounded
        v-model="toAdd"
        :data="ingredientSuggestions"
        placeholder="e.g. sugar, potato, brocolli etc."
        icon="magnify"
        @select="addIngredient"
      >
        <template slot="empty">No results found</template>
      </b-autocomplete>
      <div class="bad-ingredients" style="margin-bottom:20px">
        <div v-for="(ingredient, index) in ingredients" v-bind:key="index" class="tag is-medium">
          {{ingredient}}
          <button class="delete is-small" @click="deleteIngredient(index)"></button>
        </div>
      </div>

      <p style="margin-bottom:10px">
        <b>Calorie Preference</b>
      </p>
      <div class="calories question">
        <b-radio v-model="calorieSelection" name="name" native-value="Low">Low</b-radio>
        <b-radio v-model="calorieSelection" name="name" native-value="Average">Average</b-radio>
        <b-radio v-model="calorieSelection" name="name" native-value="High">High</b-radio>
      </div>

      <div class="button" style="width:100%">Submit</div>
    </section>
  </div>
</template>

<script>
export default {
  name: "setup",
  data() {
    return {
      toAdd: "",
      ingredients: [],
      diets: ["Omnivore", "Vegetarian", "Vegan"],
      dietSelection: "",
      calorieSelection: ""
    };
  },
  methods: {
    addIngredient(ingredient) {
      if (ingredient !== null) {
        if (!this.ingredients.includes(ingredient)) {
          this.ingredients.push(ingredient);
        }
        setTimeout(() => {
          this.toAdd = "";
        }, 0); //doesn't work without setTimeout
      }
    },
    deleteIngredient(value) {
      this.ingredients.splice(value, 1);
    },
    getIngredients() {
      //TODO: get ingredients from backend (input = toAdd)
      return ["sugar", "potato", "brocolli"];
    }
  },
  computed: {
    ingredientSuggestions() {
      return this.getIngredients().filter(ingredient => {
        return (
          ingredient
            .toString()
            .toLowerCase()
            .indexOf(this.toAdd.toLowerCase()) >= 0
        );
      });
    }
  },
  mounted: {
    getDiets() {
      //TODO: get diets from backend
    }
  }
};
</script>

<style lang="scss">
@import "../styles/variables.scss";

.setup {
  max-width: 800px;
  margin: auto;
  text-align: left;
  padding: 20px;
}

.question {
  margin-bottom: 30px;
}

.diets {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 20px;
}

.calories {
  display: flex;
  justify-content: space-around;
}

.bad-ingredients {
  margin-top: 10px;
  display: flex;
  align-items: center;
  flex-wrap: wrap;
}

.tag {
  margin: 0 10px 10px 0;
  display: flex;
  align-items: center;
}
</style>
