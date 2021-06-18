<template>
  <div>

            <header>学生：个人信息</header>
            <el-form  :model="from" label-width="80px" :rules="rules">
              <el-form-item label="学号"  >
                <el-input v-model="from.stunum"  readOnly disable></el-input>
              </el-form-item>
              <el-form-item label="姓名"  >
                <el-input v-model="from.stuname"  ></el-input>
              </el-form-item>
              <el-form-item label="身份证号"  >
                <el-input v-model="from.stuidc"  ></el-input>
              </el-form-item>
              <el-form-item label="入学年份"  >
                <el-input v-model="from.stuyear"  ></el-input>
              </el-form-item>
              <el-form-item label="生源地"  >
                <el-input v-model="from.stufrom"  ></el-input>
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
     // this.stunum=this.$route.query.id
     // alert(id)
    console.log("进入前"+_this.from)
    this.$http.get('http://localhost:8181/student/findById/'+this.$route.query.id)
        .then(function(resp){
      _this.from = resp.data
          //alert(_this.from.stunum)
          this.id=this.$route.query.id
          this.grpQryByIdReadOnlyid = "/student/grpQryByIdReadOnly:/"+this.$route.query.id
         // alert(this.stunum=this.$route.query.id)
          console.log("函数中")
          console.log(_this.from)
    })

  },
  methods: {
    onSubmit() {
      const _this = this;
      console.log('修改按钮');
      alert("已经提交")
      console.log('http://localhost:8181/student/save',this.from);
      this.$http.post('http://localhost:8181/student/save',this.from).then(function(resp){
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
        stunum: '',
        stuname: '',
        stugender: '',
        stuidc: '',
        stuyear: '',
        stufrom: '',
        id:'',
        grpQryByIdReadOnlyid: null
      },
      total: null
    }
  }
}
</script>
