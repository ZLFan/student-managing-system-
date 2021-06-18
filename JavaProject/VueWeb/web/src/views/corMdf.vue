<template>
  <div>
    <header>管理员：修改课程</header>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="课程号" prop="cornum">
        <el-input v-model="ruleForm.cornum" readOnly></el-input>
      </el-form-item>
      <el-form-item label="课程名" prop="corname">
        <el-input v-model="ruleForm.corname"></el-input>
      </el-form-item>
      <el-form-item label="开课学期" prop="corterm">
        <el-input v-model="ruleForm.corterm"></el-input>
      </el-form-item>
      <el-form-item label="课程简介" prop="corinfo">
        <el-input v-model="ruleForm.corinfo"></el-input>
      </el-form-item>
      <el-form-item label="学分" prop="corcredit">
        <el-input v-model="ruleForm.corcredit"></el-input>
      </el-form-item>
      <el-form-item label="任课教师号" prop="teanum">
        <el-input v-model="ruleForm.teanum"></el-input>
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
        cornum: '1',
        corname: '',
        corterm: '',
        corinfo: '',
        corcredit: '',
        teanum: ''
      },
      rules: {
        // cornum: [
        //   { required: true, message: '请输入课程号', trigger: 'blur' },
        //   { min: 0, max: 255, message: '长度在 255 个字符之内', trigger: 'blur' }
        // ],
        corname: [
          { required: true, message: '请输入课程名', trigger: 'blur' },
          { min: 0, max: 255, message: '长度在 255 个字符之内', trigger: 'blur' }
        ],
        corterm: [
          { required: true, message: '请输课程学期', trigger: 'blur' },
          { min: 0, max: 2021, message: '1-8', trigger: 'blur' }
        ],
        corinfo: [
          { required: true, message: '请输入课程信息', trigger: 'blur' },
          { min: 0, max: 255, message: '长度在 255 个字符之内', trigger: 'blur' }
        ],
        corcredit: [
          { required: true, message: '请输课程学分', trigger: 'blur' },
          { min: 0, max: 2021, message: '1-5', trigger: 'blur' }
        ],
        teanum: [
          { required: false, message: '请输入生源地', trigger: 'blur' },
          { min: 0, max: 255, message: '长度在 255 个字符之内', trigger: 'blur' }
        ]
      }
    };
  },
  methods: {
    submitForm(formName) {
      const _this=this
      this.$refs[formName].validate((valid) => {
        if (valid) {
          //alert('成功提交!');
          //console.log(_this.ruleForm);
          this.$http.post('http://localhost:8181/course/save',this.ruleForm).then(function(resp){
            //console.log(resp.ok);
            if(resp.ok==true)
            {
              console.log(resp.ok);
              _this.$alert('课程'+_this.ruleForm.corname+'修改成功', 'OK', {
                confirmButtonText: '确定',
                callback: action => {
                  _this.$router.push('/Index_adm/corQty')//返回查询界面
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
    console.log("modify course")
    // alert(this.$route.query.id)
    const _this = this
    this.$http.get('http://localhost:8181/course/findById/'+this.$route.query.id).then(function(resp){
      _this.ruleForm=resp.data
      // alert(_this.ruleForm)
    })
  }
}
</script>
