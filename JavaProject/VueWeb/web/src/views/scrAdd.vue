<template>
  <div>
    <header>选课</header>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="学号" prop="stunum">
        <el-input v-model="ruleForm.stunum" ></el-input>
      </el-form-item>
      <el-form-item label="课程号" prop="cornum">
        <el-input v-model="ruleForm.cornum" ></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>

</template>

<script>
export default {
  data() {
    return {
      ruleForm: {
        stunum: '',
        cornum: ''
      },
      rules: {
        stunum: [
          { required: true, message: '请输入学号', trigger: 'blur' },
          { min: 0, max: 255, message: '长度不超过255', trigger: 'blur' }
        ],
        cornum: [
          { required: true, message: '请输入课程号', trigger: 'blur' },
          { min: 0, max: 255, message: '长度不超过255', trigger: 'blur' }
        ]
      }
    };
  },
  methods: {
    submitForm(formName) {
      const _this=this
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$http.post('http://localhost:8181/sc/save',this.ruleForm).then(function(resp){
            //console.log(resp.ok);
            if(resp.ok==true)
            {
              console.log(resp.ok);
              _this.$alert('学生'+_this.ruleForm.stuname+' 课程'+_this.ruleForm.cornum+' 选课成功', 'OK', {
                confirmButtonText: '确定',
                callback: action => {
                  _this.$router.push('/scrQry')//返回查询界面
                }
              });
            }
          })
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  },
  created()
  {
    // console.log("modify student")
    // alert(this.$route.query.id)
    // const _this = this
    // this.$http.get('http://localhost:8181/sc/findById/'+this.$route.query.id+'/'+this.$route.query.cor)
    //     .then(function(resp){
    //       _this.ruleForm=resp.data
    //       // alert(_this.ruleForm)
    //     })
  }
}
</script>
