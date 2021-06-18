<template>
  <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
    <el-form-item label="用户名" prop="username">
     <el-input v-model="ruleForm.username" ></el-input>
<!--  应该修改：从个人信息界面跳转过来，username只读    -->
    </el-form-item>
    <el-form-item label="密码" prop="password">
      <el-input type="password" v-model="ruleForm.password" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="确认密码" prop="checkPass">
      <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
      <el-button @click="resetForm('ruleForm')">重置</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
export default {
  data() {
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'));
      } else {
        if (this.ruleForm.checkPass !== '') {
          this.$refs.ruleForm.validateField('checkPass');
        }
        callback();
      }
      // alert("pass1"+value);
    };
    const _this = this;
    var validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'));
      } else if (value !== _this.ruleForm.password) {
        callback(new Error('两次输入密码不一致!'));
      } else {
        callback();
      }
      // alert("pass2"+value);
    };
    return {
      ruleForm: {
        username: '',
        password: '',
        checkPass: ''
      },
      rules: {
        password: [
          { validator: validatePass, trigger: 'blur' }
        ],
        checkPass: [
          { validator: validatePass2, trigger: 'blur' }
        ]
      }
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          //alert('成功提交!');
          //console.log(_this.ruleForm);
          this.$http.post('http://localhost:8181/login/save',this.ruleForm).then(function(resp){
            console.log(resp.ok);
            if(resp.ok==true)
            {
              const _this = this;
              _this.$alert('用户'+_this.ruleForm.username+'修改成功', 'OK', {
                confirmButtonText: '确定',
                callback: action => {
                  _this.$router.push('/Index_student/student')//返回查询界面，应该修改，返回个人信息页面
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
  }
}
</script>
