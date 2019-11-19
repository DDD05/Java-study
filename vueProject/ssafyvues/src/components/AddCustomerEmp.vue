<template>
  <div>
    <form action method="POST" name="frmForm" id="_frmForm" @submit.prevent="addEmp">
      <table class="content_table">
        <colgroup>
          <col style="width:30%" />
          <col style="width:70%" />
        </colgroup>
        <tr>
          <th>이름</th>
          <td>
            <input type="text" name="name" id="_name" size="30" v-model="emp.cname" />
          </td>
        </tr>
        <tr>
          <th>이메일</th>
          <td>
            <input type="text" name="mailid" id="_mailid" size="20" v-model="emp.cmailid" />
          </td>
        </tr>
        <tr>
          <th>고용일</th>
          <td>
            <input
              type="date"
              name="start_date"
              id="_start_date"
              size="30"
              v-model="emp.cstart_date"
            />
          </td>
        </tr>
        <tr>
          <th>관리자</th>
          <td>
            <select name="manager_id" v-model="emp.cmanager_id">
              <option
                v-for="(e,index) in info"
                :key="index"
                v-bind:value="e.id"
              >{{e.id}} : {{e.name}}</option>
            </select>
          </td>
        </tr>
        <tr>
          <th>직책</th>
          <td>
            <select name="title" v-model="emp.ctitle">
              <option v-for="(t,idx) in titles" :key="idx" v-bind:value="t">{{t}}</option>
            </select>
          </td>
        </tr>
        <tr>
          <th>부서</th>
          <td>
            <select name="dept_id" v-model="emp.cdept_id">
              <option
                v-for="(dept,idx) in depts"
                :key="idx"
                v-bind:value="dept.dept_id"
              >{{dept.dept_id}} : {{dept.name}}</option>
            </select>
          </td>
        </tr>
        <tr>
          <th>월급</th>
          <td>
            <input type="number" name="salary" id="_salary" size="30" v-model="emp.csalary" min="0" />
          </td>
        </tr>
        <tr>
          <th>커미션</th>
          <td>
            <input
              type="number"
              name="commission_pct"
              id="_commission_pct"
              size="30"
              v-model="emp.ccommission"
              min="0"
            />
          </td>
        </tr>
        <tr>
          <td colspan="2" style="height: 50px; text-align: center;">
            <button type="submit" name="button">사원 추가</button>
          </td>
        </tr>
      </table>
    </form>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "addcustomeremp",
  data: () => {
    return {
      emp: {
        cname: "",
        cmailid: "",
        cstart_date: "",
        cmanager_id: "",
        ctitle: "",
        cdept_id: "",
        csalary: "",
        ccommission: ""
      },
      info: null,
      error: false,
      loading: true,
      titles: [],
      depts: {}
    };
  },
  methods: {
    addEmp: function() {
      axios
        .post("http://localhost:9999/api/addEmployee", {
          name : this.emp.cname,
          mailid : this.emp.cmailid,
          start_date : this.emp.cstart_date,
          manager_id : this.emp.cmanager_id,
          title : this.emp.title,
          dept_id : this.emp.dept_id,
          salary : this.emp.csalary,
          commission : this.emp.ccommission
        })
        .then(() => {
          location.href="/"
        })
        .catch(() => {
          this.error = true;
        });
    }
  },
  mounted() {
    axios
      .get("http://localhost:9999/api/findAllEmployees")

      .then(response => {
        this.info = response.data;

        for (var emp of this.info) {
          if (!this.titles.includes(emp.title)) this.titles.push(emp.title);
        }

        this.depts = [
          { dept_id: "110", name: "기획부" },
          { dept_id: "111", name: "기획부" },
          { dept_id: "112", name: "기획부" },
          { dept_id: "113", name: "기획부" },
          { dept_id: "102", name: "영업부" },
          { dept_id: "103", name: "영업부" },
          { dept_id: "104", name: "영업부" },
          { dept_id: "105", name: "영업부" },
          { dept_id: "106", name: "영업부" },
          { dept_id: "118", name: "인사부" },
          { dept_id: "101", name: "총무부" },
          { dept_id: "120", name: "회계부" }
        ];
      })
      .catch(() => {
        this.errored = true;
      })
      .finally(() => (this.empEmpty = false));
  }
};
</script>

<style lang="scss" scoped>
</style>


