<template>
  <div>
    <header>我的班级</header>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="班级号" prop="groupnum">
        <el-input v-model="ruleForm.groupnum" readOnly></el-input>
      </el-form-item>
      <el-form-item label="教师号" prop="teanum">
        <el-input v-model="ruleForm.teanum" readOnly></el-input>
      </el-form-item>
      <el-form-item label="班长" prop="headmaster">
        <el-input v-model="ruleForm.headmaster" ></el-input>
      </el-form-item>
      <el-form-item label="生活委员" prop="life">
        <el-input v-model="ruleForm.life" ></el-input>
      </el-form-item>
      <el-form-item label="学习委员" prop="study">
        <el-input v-model="ruleForm.study" ></el-input>
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
    // _this.id='100038'
    _this.id=this.$route.query.id
     this.$http.get('http://localhost:8181/banji/findByTeanum/'+_this.id).then(function(r){
       //console.log("ddd"+r)
    this.$http.get('http://localhost:8181/banji/findById/'+r.data.groupnum).then(function(resp){
      _this.ruleForm=resp.data
       alert(_this.ruleForm)
    })
      // alert(_this.ruleForm)
    })
    console.log('after')
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          //alert('成功提交!');
          //console.log(_this.ruleForm);
          this.$http.post('http://localhost:8181/banji/save',this.ruleForm).then(function(resp){
            console.log(resp.ok);
            if(resp.ok==true)
            {
              const _this = this;
              _this.$alert('班级'+_this.ruleForm.groupnum+'修改成功', 'OK', {
                confirmButtonText: '确定',
                callback: action => {
                  _this.$router.push('/grpQryByTeaWritePartly')//返回查询界面，应该修改，返回个人信息页面
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
        groupnum: '',
        teanum: '',
        headmaster: '',
        study: '',
        life: '',
        id: ''
      },
      tableData: null,
      total: null,
      search: '',
      rules: {

        headmaster: [
          { required: true, message: '请输入班长学号', trigger: 'blur' },
          { min: 0, max: 100, message: '0-100', trigger: 'blur' }
        ],
        life: [
          { required: true, message: '请输入生活委员学号', trigger: 'blur' },
          { min: 0, max: 100, message: '0-100', trigger: 'blur' }
        ],
        study: [
          { required: true, message: '请输入学习委员学号', trigger: 'blur' },
          { min: 0, max: 100, message: '0-100', trigger: 'blur' }
        ]

      }
    }
  },
}
</script>
