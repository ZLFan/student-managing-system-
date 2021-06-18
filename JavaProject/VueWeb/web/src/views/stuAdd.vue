<template>
  <div>
    <header>管理员：添加学生</header>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="学号" prop="stunum">
        <el-input v-model="ruleForm.stunum"></el-input>
      </el-form-item>
      <el-form-item label="姓名" prop="stuname">
        <el-input v-model="ruleForm.stuname"></el-input>
      </el-form-item>
      <el-form-item label="性别" prop="stugender">
        <el-select v-model="ruleForm.stugender" placeholder="请选择性别">
          <el-option label="男" value="男"></el-option>
          <el-option label="女" value="女"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="身份证号" prop="stuidc">
        <el-input v-model="ruleForm.stuidc"></el-input>
      </el-form-item>
      <el-form-item label="入学年份" prop="stuyear">
        <el-input v-model="ruleForm.stuyear"></el-input>
      </el-form-item>
      <el-form-item label="生源地" prop="stufrom">
        <el-input v-model="ruleForm.stufrom"></el-input>
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
        stuname: '',
        stugender: '',
        stuidc: '',
        stuyear: '',
        stufrom: ''
      },
      rules: {
        stunum: [
          { required: true, message: '请输入学号', trigger: 'blur' },
          { min: 0, max: 255, message: '长度在 255 个字符之内', trigger: 'blur' }
        ],
        stuname: [
          { required: true, message: '请输入姓名', trigger: 'blur' },
          { min: 0, max: 255, message: '长度在 255 个字符之内', trigger: 'blur' }
        ],
        stugender: [
          { required: true, message: '请选择性别', trigger: 'change' }
        ],
        stuidc: [
          { required: true, message: '请输入身份证号', trigger: 'blur' },
          { min: 0, max: 255, message: '长度在 255 个字符之内', trigger: 'blur' }
        ],
        stuyear: [
          { required: true, message: '请输入入学年份', trigger: 'blur' },
          { min: 0, max: 255, message: '1990-2021', trigger: 'blur' }
        ],
        stufrom: [
          { required: true, message: '请输入生源地', trigger: 'blur' },
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
          this.$http.post('http://localhost:8181/student/save',this.ruleForm).then(function(resp){
            console.log(resp.ok);
            // if(resp.ok==true)
            // {
            //   console.log(resp.ok);
            //   _this.$alert('学生'+_this.ruleForm.stuname+'添加成功', 'OK', {
            //     confirmButtonText: '确定',
            //     callback: action => {
            //       _this.$router.push('/stuQry')//返回查询界面
            //     }
            //   });
            // }
            this.$http.post('http://localhost:8181/login/saveId/'+this.ruleForm.stunum+'/'+this.ruleForm.stunum+'/3').then(function(res){
              //console.log(resp.ok);
              if(res.ok==true)
              {
                console.log(res.ok);
                _this.$alert('学生'+_this.ruleForm.stunum+'添加成功', 'OK', {
                  confirmButtonText: '确定',
                  callback: action => {
                    _this.$router.push('/stuQry')//返回查询界面
                  }
                });
              }
            })
          })


        } else {
          alert('error submit!!');
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

