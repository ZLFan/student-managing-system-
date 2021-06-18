<template>
  <div>
    <header>我的课程</header>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="课程号" prop="cornum">
        <el-input v-model="ruleForm.cornum" readOnly></el-input>
      </el-form-item>
      <el-form-item label="课程名" prop="corname">
        <el-input v-model="ruleForm.corname" readOnly></el-input>
      </el-form-item>
      <el-form-item label="课程学期" prop="corterm">
        <el-input v-model="ruleForm.corterm" readOnly></el-input>
      </el-form-item>
      <el-form-item label="课程介绍" prop="corinfo">
        <el-input v-model="ruleForm.corinfo" readOnly></el-input>
      </el-form-item>
      <el-form-item label="课程学分" prop="corcredit">
        <el-input v-model="ruleForm.corcredit" readOnly></el-input>
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
  created: function () {
    console.log('before')
    const _this = this
    _this.id=this.$route.query.id
     this.$http.get('http://localhost:8181/course/findByTeanum/'+_this.id).then(function(resp){
       _this.ruleForm=resp.data
    })
    console.log('after')
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          //alert('成功提交!');
          //console.log(_this.ruleForm);
          this.$http.post('http://localhost:8181/course/save',this.ruleForm).then(function(resp){
            console.log(resp.ok);
            if(resp.ok==true)
            {
              const _this = this;
              _this.$alert('课程'+_this.ruleForm.corname+'修改成功', 'OK', {
                confirmButtonText: '确定',
                callback: action => {
                  _this.$router.push('/corQtyByTeaWritePartly')//返回查询界面，应该修改，返回个人信息页面
                }
              });
            }
          })
        } else {
          alert('error submit!');
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  },
  data () {
    return {
      ruleForm:{
        cornum: '',
        corname: '',
        corterm: '',
        corinfo: '',
        corcredit: '',
        id: ''
      },
      tableData: null,
      total: null,
      search: '',
      rules: {
        corinfo: [
          { required: true, message: '请输入课程信息', trigger: 'blur' }
        ]
      }
    }
  },
}
</script>
