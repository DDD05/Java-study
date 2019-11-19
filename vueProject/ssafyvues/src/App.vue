<!-- 아래 화면단(router)을 출력하는 일 외에는 딱히 하는 일이 없다.-->
<template>
<div id="app">
<div class='headtitle'><h2>SSAFY HRM LIST</h2></div>
<div class='search_box'>
 <nav>
   <!--
     1. 라우터 속성 to에 지정된 경로를 찾음
     2. 사용자가 화면에서 라우터 링크에 대응하는 html 링크를 클릭하면
      2-1. router.js로 이동해서 라우터들을 검색함(to="/url" ----- path="/")
      2-2. 아래의 속성값에 매핑되는  라우터 경로를 찾아냄.
         routes: [
            {
              path: "/",
              name: "customers",
              alias: "/customer",
              component: CustomersList
            }
          ]
      2-3. 연결된 컴포넌트를 router-view영역에 실행함.
    -->
        <router-link class="btn btn-primary" to="/addcustomeremp">사원 추가하기</router-link> |
        <router-link class="btn btn-primary" to="/searchbyname">사원 이름으로 검색하기</router-link> |
        <router-link class="btn btn-primary" to="/searchbyid">사원 ID로 검색하기</router-link> |
        <router-link class="btn btn-primary" to="/">모든사원 보기</router-link> |
        <router-link class="btn btn-primary" to="/chartcustomer">부서별 인원보기</router-link> |
 </nav>
</div>
        <router-view/>
</div>
</template>

<script>
export default {
  name: "app"
};
</script>

<style>

</style>
 
