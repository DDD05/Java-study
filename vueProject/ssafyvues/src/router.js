import Vue from "vue";
import Router from "vue-router";
import CustomersList from "./components/CustomersList.vue";
import searchbyid from "./components/SearchCustomersById.vue";
import searchbyname from "./components/SearchCustomersByName.vue";
Vue.use(Router);

export default new Router({
  mode: "history",
  routes: [
    {
      path: "/",
      name: "customers",
      alias: "/customer",
      component: CustomersList
    },
    {
      path: "/searchbyid",
      name: "searchbyid",
      component: searchbyid
    },
    {
      path: "/searchbyname",
      name: "searchbyname",
      component: searchbyname
    }
  ]
});
