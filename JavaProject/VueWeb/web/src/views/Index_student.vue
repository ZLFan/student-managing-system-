
<template>
  <div id="app">

    <el-container style="height: 900px; border: 1px solid #eee">

      <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
        <el-menu :default-openeds="['1','2']"  router= "router"    :default-active="$route.path">



            <el-menu-item :index="msgid">个人信息</el-menu-item>
            <el-menu-item :index="msgupdata">教师列表</el-menu-item>
            <el-menu-item :index="courselist_student">我的班级</el-menu-item>
            <el-menu-item :index="courselisted_student">本班同学</el-menu-item>
            <el-menu-item :index="msg1">所有课程</el-menu-item>
          <el-menu-item :index="msg4">选课</el-menu-item>
            <el-menu-item :index="msg2">我的成绩</el-menu-item>
            <el-menu-item :index="msg3">修改密码</el-menu-item>



            <!-- <el-menu-item index="2-3">选项3</el-menu-item> -->
          <el-menu-item index="/Login">退出系统</el-menu-item>
        </el-menu>
      </el-aside>

      <el-container>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>

    </el-container>

  </div>
</template>


<style>
.el-header {
  background-color: #B3C0D1;
  color: #333;
  line-height: 60px;
}

.el-aside {
  color: #333;
}
</style>

<script>
export default {
  created(){
    const _this=this
    this.id=this.$route.query.id
    this.msgid = "/Index_student/student?id="+this.id
    this.msgupdata="/Index_student/teaQryReadOnly?id="+this.id
    this.courselist_student="/Index_studentgrpQryByIdReadOnly?id="+this.id
    this.courselisted_student="/Index_student/grpBySnumReadOnly?id="+this.id
    this.courselisted_student="/Index_student/grpBySnumReadOnly?id="+this.id
    this.msg1="/Index_student/corQryReadOnly?id="+this.id
    this.msg4="/Index_student/scrAddByS?id="+this.id
    this.msg2="/Index_student/scrQryByIdReadOnly?id="+this.id
    this.msg3="/Index_student/LogMdf?id="+this.id

    //  axios.get('http://localhost:8181/student/getclasslists').then(function (params) {
    //    _this.allclass=params.data
    //    console.log(params.data)
    //  })
    // axios.get('http://localhost:8181/student/findall/1/5').then(function (resp) {
    //   _this.tableData=resp.data.content
    //   _this.total=resp.data.totalElements

    // })
  },
  data() {
     const item = {
      id:null,
      msgid:null,
      msgupdata:null,
      courselist_student:null,
      courselisted_student:null,
      msg1:null,
      msg2:null,
      msg3:null,
       msg4:null
    };
    return {
      tableData: Array(20).fill(item)
    };

  }
};
</script>
