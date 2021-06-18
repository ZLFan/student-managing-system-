<template>
  <div>
    <header>管理员：修改班级</header>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="班级号" prop="groupnum">
        <el-input v-model="ruleForm.groupnum" readOnly></el-input>
      </el-form-item>
      <el-form-item label="教师号" prop="teanum">
        <el-input v-model="ruleForm.teanum"></el-input>
      </el-form-item>
      <el-form-item label="班长" prop="headmaster">
        <el-input v-model="ruleForm.headmaster"></el-input>
      </el-form-item>
      <el-form-item label="生活委员" prop="life">
        <el-input v-model="ruleForm.life"></el-input>
      </el-form-item>
      <el-form-item label="学习委员" prop="study">
        <el-input v-model="ruleForm.study"></el-input>
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
        groupnum: '',
        teanum: '',
        headmaster: '',
        life: '',
        study: ''
      },
      rules: {
        groupnum: [
          { required: true, message: '请输入班级号', trigger: 'blur' },
          { min: 0, max: 255, message: '长度在 255 个字符之内', trigger: 'blur' }
        ],
        teanum: [
          { required: true, message: '请输入教师号', trigger: 'blur' },
          { min: 0, max: 255, message: '长度在 255 个字符之内', trigger: 'blur' }
        ],
        headmaster: [
          { required: true, message: '请输入班长学号', trigger: 'blur' },
          { min: 0, max: 255, message: '长度在 255 个字符之内', trigger: 'blur' }
        ],
        life:[
          { required: true, message: '请输入生活委员学号', trigger: 'blur' },
          { min: 0, max: 255, message: '长度在 255 个字符之内', trigger: 'blur' }
        ],
        study: [
          { required: true, message: '请输入学习委员学号', trigger: 'blur' },
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
          this.$http.post('http://localhost:8181/banji/save',this.ruleForm).then(function(resp){
            //console.log(resp.ok);
            if(resp.ok==true)
            {
              console.log(resp.ok);
              _this.$alert('班级'+_this.ruleForm.groupnum+'修改成功', 'OK', {
                confirmButtonText: '确定',
                callback: action => {
                  _this.$router.push('/Index_adm/grpQty')//返回查询界面
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
    console.log("modify group")
    // alert(this.$route.query.id)
    const _this = this
    this.$http.get('http://localhost:8181/banji/findById/'+this.$route.query.id).then(function(resp){
      _this.ruleForm=resp.data
      // alert(_this.ruleForm)
    })
  }
}
</script>
