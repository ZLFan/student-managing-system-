<template>
  <el-container style="height: 700px; border: 1px solid #eee">
    <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
      <el-menu router>
        <el-submenu v-for="(item,index) in $router.options.routes":index="index+'' " v-if="item.show">
          <template slot="title"><i class="el-icon-circle-plus-outline"></i>{{item.name}}</template>
          <el-menu-item v-for="(item2,index2) in item.children":index="item2.path">{{item2.name}}</el-menu-item>
<!--          <el-menu-item v-for="(item2,index2)in item.children":index="item2.path">{{// item2.name}}}</el-menu-itemv-for>-->
        </el-submenu>
      </el-menu>
    </el-aside>
    <el-container>
      <el-header style="text-align: right; font-size: 30px">
        <el-dropdown>
          <!--            <i class="el-icon-setting" style="margin-right: 15px"></i>-->
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>查看</el-dropdown-item>
            <el-dropdown-item>新增</el-dropdown-item>
            <el-dropdown-item>删除</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
        <span>学生成绩管理系统</span>
      </el-header>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  name: 'Index',
  created(){
    const _this=this
    this.id=this.$route.query.id
    alert(id)
    console.log(id)
    // this.msgid = "/teacher/teacher_msg?id="+this.id
    // this.msgupdata="/teacher/teacher_msg_updata?id="+this.id
    // this.courselist_student="/teacher/coursemag?id="+this.id
    // this.courselisted_student="/student_index/courselisted_student?id="+this.id

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
      id:null
      // msgid:null,
      // msgupdata:null,
      // courselist_student:null,
      // courselisted_student:null
    }
}
</script>

<style scoped>

</style>
