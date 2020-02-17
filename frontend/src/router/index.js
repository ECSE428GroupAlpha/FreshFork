import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: Home
  },
  {
    path: "/about",
    name: "about",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About.vue")
  },
  {
    path: "/setup",
    name: "setup",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/Setup.vue")
  },
  {
    path: "/userprofile",
    name: "UserProfile",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/UserProfile.vue")
  },
  {
    path: "/createRecipe",
    name: "createRecipe",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/CreateRecipe.vue")
  }
];

const router = new VueRouter({
  routes
});

export default router;
