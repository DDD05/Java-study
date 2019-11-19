import Vue from "vue";
import App from "./App.vue";
import router from './router'

Vue.config.productionTip = false;

new Vue({
  router,
  render: h => h(App)
}).$mount("#app");

/*
  시발점
1. vue 객체를 생성
2. render에서 h함수로 App.vue를 지정 (호출)
3. index.html에서 app영역을 찾아서 그부분에 vue 템플릿을 마운트한다.
*/