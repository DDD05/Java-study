import Vue from "vue";
import Router from "vue-router";
import CustomersList from "./components/CustomersList.vue";
import searchbyid from "./components/SearchCustomersById.vue";
import searchbyname from "./components/SearchCustomersByName.vue";
import detailcustomer from "./components/Detailcustomer.vue";
import addcustomeremp from "./components/AddCustomerEmp.vue";
import chartcustomer from "./components/ChartCustomer.vue";
import updatecustomer from "./components/UpdateCustomerEmp.vue";
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
      component: searchbyid
    },
    {
      path: "/searchbyname",
      component: searchbyname
    },
    {
      path: "/detailcustomer/:id",
      component: detailcustomer,
      props: true
    },
    {
      path: "/updatecustomer/:id",
      component: updatecustomer,
      props: true
    },
    {
      path: "/addcustomeremp",
      component: addcustomeremp
    },
    {
      path: "/chartcustomer",
      component: chartcustomer
    }
  ]
});
