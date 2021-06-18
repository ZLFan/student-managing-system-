
<template>
  <div id="app">

    <el-container style="height: 900px; border: 1px solid #eee">

      <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
        <el-menu :default-openeds="['1','2']"  router= "router"    :default-active="$route.path">



          <el-menu-item :index="msgid">个人信息</el-menu-item>
          <el-menu-item :index="msgupdata">所有教师</el-menu-item>
          <el-menu-item :index="courselist_student">增加教师</el-menu-item>
          <el-menu-item :index="courselisted_student">所有课程</el-menu-item>
          <el-menu-item :index="msg1">增加课程</el-menu-item>
          <el-menu-item :index="msg2">所有班级</el-menu-item>
          <el-menu-item :index="msg4">增加班级</el-menu-item>
          <el-menu-item :index="msg5">为班级添加学生</el-menu-item>
          <el-menu-item :index="msg6">所有学生</el-menu-item>
          <el-menu-item :index="msg7">增加学生</el-menu-item>
          <el-menu-item :index="msg8">所有学生成绩</el-menu-item>
          <el-menu-item :index="msg9">选课</el-menu-item>
          <el-menu-item :index="msg10">修改密码</el-menu-item>
          <!--          <el-menu-item :index="msg3">修改密码</el-menu-item>-->



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
    this.msgid = "/Index_adm/adm?id="+this.id
    this.msgupdata="/Index_adm/tea?id="+this.id
    this.courselist_student="/Index_adm/teaAdd?id="+this.id
    this.courselisted_student="/Index_adm/corQty?id="+this.id
    // this.courselisted_student="/Index_grpt/scrQryByBanjiReadOnly?id="+this.id
    this.msg1="/Index_adm/corAdd?id="+this.id
    this.msg2="/Index_adm/grpQry?id="+this.id
    this.msg4="/Index_adm/grpAdd?id="+this.id
    this.msg5="/Index_adm/sgAdd?id="+this.id
    this.msg6="/Index_adm/stuQry?id="+this.id
    this.msg7="/Index_admstuAdd?id="+this.id
    this.msg8="/Index_adm/scrQry?id="+this.id
    this.msg9="/Index_adm/scrAdd?id="+this.id
    this.msg10="/Index_adm/LogMdf?id="+this.id

  },
  data() {
    const item = {
      // date: '2016-05-02',
      // name: '不爱喝茶的玄月',
      // address: '上海市普陀区金沙江路 1518 弄',
      id:null,
      msgid:null,
      msgupdata:null,
      courselist_student:null,
      courselisted_student:null,
      msg1:null,
      msg2:null,
      msg4:null,
      msg5:null,
      msg6:null,
      msg7:null,
      msg8:null,
      msg9:null,
      msg10:null,
    };
    return {
      tableData: Array(20).fill(item)
    };

  }
};
</script>
