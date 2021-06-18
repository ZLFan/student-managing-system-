<template>
  <div>
    <header>管理员:班级</header>
    <el-table
        :data="tableData.filter(data => !search || data.groupnum.toLowerCase().includes(search.toLowerCase())
                                            ||data.teanum.toLowerCase().includes(search.toLowerCase())
                                            ||data.headmaster.toLowerCase().includes(search.toLowerCase())
                                            ||data.life.toLowerCase().includes(search.toLowerCase())
                                            ||data.study.toLowerCase().includes(search.toLowerCase())
                           )"
        style="width: 100%">
      <el-table-column
          label="班级号"
          prop="groupnum">
      </el-table-column>
      <el-table-column
          label="教师号"
          prop="teanum">
      </el-table-column>
      <el-table-column
          label="班长"
          prop="headmaster">
      </el-table-column>
      <el-table-column
          label="生活委员"
          prop="life">
      </el-table-column>
      <el-table-column
          label="学习委员"
          prop="study">
      </el-table-column>
      <el-table-column
          align="right">
        <template slot="header" slot-scope="{}">
          <el-input
              v-model="search"
              size="mini"
              placeholder="输入关键字搜索"/>
        </template>
        <template slot-scope="scope">
          <el-button
              size=""
              @click="edit(scope.row)">修改</el-button>
          <el-button
              size="mini"
              type="danger"
              @click="deleteGroup (scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>

</template>

<script>
export default {
  created: function () {

    const _this=this
    this.$http.get('http://localhost:8181/banji/findAll').then(function (resp) {
      _this["tableData"] = resp.data
      console.log(resp.data)
      console.log(_this.total)
    })
  },
  methods: {
    edit (row) {
      //console.log(row)
      this.$router.push({
        path: '/grpMdf',
        query: {
          id: row.groupnum
        }
      })
      console.log(row.groupnum);
    },
    deleteGroup (row){
      this.$http.delete('http://localhost:8181/banji/deleteById/'+row.groupnum).then(function(resp){
        const _this=this
        _this.$alert('班级'+row.groupnum+'删除成功', 'OK', {
          confirmButtonText: '确定',
          callback: action => {
            window.location.reload()//动态刷新查询结果
          }
        })
      })
    }
  },
  data () {
    return {
      ruleForm:{
        groupnum: '',
        teanum: '',
        headmaster: '',
        study: '',
        life: ''
      },
      tableData: null,
      total: null,
      search: ''
    }
  },
}
</script>
