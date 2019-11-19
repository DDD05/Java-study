<template>
  <div>
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
      <tr v-if="emp != null">
        <td v-html="emp.id"></td>
        <td v-html="emp.name"></td>
        <td v-html="emp.dept_id"></td>
        <td v-html="emp.title"></td>
        <td>{{ emp.salary  }}</td>
      </tr>
    </table>
    <br>
    <h2>부하직원보기</h2>
    <br>
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
      <tr v-for="(item, index) in lemps" :key="index"> 
        <td v-html="item.id"></td>
        <td v-html="item.name"></td>
        <td v-html="item.dept_id"></td>
        <td v-html="item.title"></td>
        <td>{{ item.salary  }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "detailcustomer",
  props: ["id"],
  data() {
    return {
      emp: null,
      lemps: null,
      loading: true,
      errored: false
    };
  },
  filters: {
    salaryDouble: function(value) {
      return Math.round(value).toFixed(2);
    }
  },
  mounted() {
    var employeeid = this.id;
    axios
      .get("http://localhost:9999/api/findEmployeeById/" + employeeid)

      .then(response => (this.emp = response.data))
      .catch(() => {
        this.errored = true;
      })
      .finally(() => (this.loading = false));

    axios
      .get("http://localhost:9999/api/findEmployeesByManagerId/" + employeeid)

      .then(response => (this.lemps = response.data))
      .catch(() => {
        this.errored = true;
      })
      .finally(() => (this.loading = false));
  }
};
</script>

<style lang="scss" scoped>
</style>


