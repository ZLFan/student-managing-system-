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
        <el-input v-model="ruleForm.headmaster" readOnly></el-input>
      </el-form-item>
      <el-form-item label="生活委员" prop="life">
        <el-input v-model="ruleForm.life" readOnly></el-input>
      </el-form-item>
      <el-form-item label="学习委员" prop="study">
        <el-input v-model="ruleForm.study" readOnly></el-input>
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
     this.$http.get('http://localhost:8181/sg/findByStunum/'+_this.id).then(function(r){
       //console.log("ddd"+r)
    this.$http.get('http://localhost:8181/banji/findById/'+r.data[0].groupnum).then(function(resp){
      _this.ruleForm=resp.data
       alert(_this.ruleForm)
    })
      // alert(_this.ruleForm)
    })
    console.log('after')
  },
  methods: {
  },
  data () {
    return {
      ruleForm:{
        groupnum: '',
        teanum: '',
        headmaster: '',
        study: '',
        life: '',
        id: '1181002038'
      },
      tableData: null,
      total: null,
      search: ''
    }
  },
}
</script>
