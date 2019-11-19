<template>
  <div>
    <div class="search_box">
      <select name="id" @change="findid" v-model="searching">
        <option v-for="emp in info" v-bind:value="emp.id" :key="emp.id">{{emp.name}}</option>
      </select>
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
      <tr v-if="empEmpty" @click="show_detail(printList.id)">
        <td v-html="printList.id"></td>
        <td v-html="printList.name"></td>
        <td v-html="printList.dept_id"></td>
        <td v-html="printList.title"></td>
        <td>{{ printList.salary | salarydecimal }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "idhrm",
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
  filters: {
    salaryDouble: function(value) {
      return Math.round(value).toFixed(2);
    }
  },
  methods: {
    findid() {
      axios
        .get("http://localhost:9999/api/findEmployeeById/" + this.searching)

        .then(response => {
          this.printList = response.data;
          this.empEmpty = true;
        })
        .catch( () => {
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


