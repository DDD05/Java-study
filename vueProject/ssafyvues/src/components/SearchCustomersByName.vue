<template>
  <div>
    <div class="search_box">
      <input type="text" v-model="searching" @keyup.enter="findname" />
    </div>
    <table class="list_table">
      <col width="10%" />
      <col width="20%" />
      <col width="20%" />
      <col width="20%" />
      <col width="10%" />
      <tr>
        <th>사원 아이디</th>
        <th>사원명</th>
        <th>부서</th>
        <th>직책</th>
        <th>연봉</th>
      </tr>
      <tr v-for="(item, index) in printList" :key="index" @click="show_detail(item.id)">
        <td v-html="item.id"></td>
        <td v-html="item.name"></td>
        <td v-html="item.dept_id"></td>
        <td v-html="item.title"></td>
        <td>{{ item.salary | salarydecimal }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "namehrm",
  data() {
    return {
      searching: "",
      printList: {},
      empEmpty: false,
      info: null,
      loading: true,
      errored: false
    };
  },
  methods: {
    findname() {
      axios
        .get("http://localhost:9999/api/findLikeEmployees/" + this.searching)

        .then(response => {
          this.printList = response.data;
          this.empEmpty = true;
        })
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    },
    // show_detail(employeeid) {
    //   this.$router.push({
    //     path: "/router5/" + employeeid,
    //     component: detailhrm
    //   });
    // }
  },
  mounted() {
    axios
      .get("http://localhost:9999/api/findAllEmployees")

      .then(response => (this.info = response.data))
      .catch(() => {
        this.errored = true;
      })
      .finally(() => (this.empEmpty = false));
  }
};
</script>

<style lang="scss" scoped>
</style>


