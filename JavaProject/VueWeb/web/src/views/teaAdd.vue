<template>
  <div>
    <header>管理员：添加教师</header>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="教师号" prop="teanum">
        <el-input v-model="ruleForm.teanum"></el-input>
      </el-form-item>
      <el-form-item label="姓名" prop="teaname">
        <el-input v-model="ruleForm.teaname"></el-input>
      </el-form-item>
      <el-form-item label="身份证号" prop="teaidc">
        <el-input v-model="ruleForm.teaidc"></el-input>
      </el-form-item>
      <el-form-item label="教师身份" prop="teaflag">
        <el-select v-model="ruleForm.teaflag" placeholder="请选择身份">
          <el-option label="任课教师" value="0"></el-option>
          <el-option label="班主任" value="1"></el-option>
          <el-option label="教秘（管理员）" value="2"></el-option>
        </el-select>
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
  created()
  {
    this.id=this.$route.query.id
  },
  data() {
    return {
      ruleForm: {
        teanum: '',
        teaname: '',
        teaidc: '',
        stuidc: '',
        teaflag: '',
        id:''
      },
      rules: {
        teanum: [
          { required: true, message: '请输入教师号', trigger: 'blur' },
          { min: 0, max: 255, message: '长度在 255 个字符之内', trigger: 'blur' }
        ],
        teaname: [
          { required: true, message: '请输入姓名', trigger: 'blur' },
          { min: 0, max: 255, message: '长度在 255 个字符之内', trigger: 'blur' }
        ],
        teaidc: [
          { required: true, message: '请输入身份证号', trigger: 'blur' },
          { min: 0, max: 255, message: '长度在 255 个字符之内', trigger: 'blur' }
        ],
        teaflag: [
          { required: true, message: '请选择身份', trigger: 'change' }
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
          this.$http.post('http://localhost:8181/teacher/save',this.ruleForm).then(function(resp){
            //console.log(resp.ok);
            // if(resp.ok==true)
            // {
              // console.log(resp.ok);
              // _this.$alert('教师'+_this.ruleForm.teaname+'添加成功', 'OK', {
              //   confirmButtonText: '确定',
              //   callback: action => {
              //     _this.$router.push('/teaQry')//返回查询界面
              //   }
              // });
            // }
            this.$http.post('http://localhost:8181/login/saveId/'+this.ruleForm.teanum+'/'+this.ruleForm.teanum+'/'+this.ruleForm.teaflag).then(function(res){
              //console.log(resp.ok);
              if(res.ok==true)
              {
                console.log(res.ok);
                _this.$alert('教师'+_this.ruleForm.teanum+'添加成功', 'OK', {
                  confirmButtonText: '确定',
                  callback: action => {
                    this.$http.post("http://localhost:8181/login/getLogFlag/"+this.id)
                    .then((r)=>
                    {
                      if(r===0)
                      {
                        _this.$router.push('/Index_cort/teaQryReadOnly')//返回查询界面
                      }
                        else if(r===1)
                      {
                        _this.$router.push('/Index_grpt/teaQryReadOnly')//返回查询界面
                      }
                          else if(r===2)
                      {
                        _this.$router.push('/Index_adm/tea')//返回查询界面
                      }
                    })

                  }
                });
              }
            })
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

  }
}
</script>

