<template>
  <div>
    <header>任课教师：个人信息</header>
    <el-form  :model="from" label-width="80px" :rules="rules">
      <el-form-item label="教师号"  >
        <el-input v-model="from.teanum"  readOnly disable></el-input>
      </el-form-item>
      <el-form-item label="姓名"  >
        <el-input v-model="from.teaname"  ></el-input>
      </el-form-item>
      <el-form-item label="身份证号"  >
        <el-input v-model="from.teaidc"  ></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">修改</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  created() {
    const _this=this;
    console.log("进入前"+_this.from)
    this.$http.get('http://localhost:8181/teacher/findById/'+this.$route.query.id)
        .then(function(resp){
          _this.from = resp.data
          //alert(_this.from.stunum)
          console.log("函数中")
          console.log(_this.from)
        })
  },
  methods: {
    onSubmit() {
      const _this = this;
      console.log('修改按钮');
      //alert("已经提交")
      //console.log('http://localhost:8181/teacher/save',this.from);
      this.$http.post('http://localhost:8181/teacher/save',this.from).then(function(resp){
        console.log(resp);
        if(resp.data) {
          _this.$message('修改成功');
        }
      })

    }
  },
  data () {
    return {
      from:{
        teanum: '',
        teaname: '',
        teaidc: ''
      },
      total: null
    }
  }
}
</script>
