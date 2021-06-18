<template>
  <div>
    <header>所有成绩</header>
    <el-table
        :data="tableData.filter(data => !search || data.stunum.toLowerCase().includes(search.toLowerCase())
                                            ||data.cornum.toLowerCase().includes(search.toLowerCase())
                                            ||data.score.toLowerCase().includes(search.toLowerCase())
                           )"
        style="width: 100%">
      <el-table-column
          label="学号"
          prop="stunum">
      </el-table-column>
      <el-table-column
          label="课程号"
          prop="cornum">
      </el-table-column>
      <el-table-column
          label="成绩"
          prop="score">
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
              @click="edit(scope.row)">修改成绩</el-button>
          <el-button
              size="mini"
              type="danger"
              @click="deleteStudent (scope.row)">退课</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>

</template>

<script>
export default {
  created: function () {

    const _this=this
    this.$http.get('http://localhost:8181/sc/findAll').then(function (resp) {
      _this["tableData"] = resp.data
    })
  },
  methods: {
    edit (row) {
      //console.log(row)
      this.$router.push({
        path: '/scrMdf',
        query: {
          id: row.stunum,
          cor:row.cornum
        }
      })
    },
    deleteStudent (row){
      this.$http.delete('http://localhost:8181/sc/deleteById/'+row.stunum+'/'+row.cornum).then(function(resp){
          const _this=this
          _this.$alert('课程:'+row.cornum+'\n'+'学生:'+row.stunum+'\n'+'退课成功', 'OK', {
            confirmButtonText: '确定',
            callback: action => {
              window.location.reload()//动态刷新查询结果
            }
          })
      })
    }//,
    // page (currentPage) {
    //   const _this=this;
    //     this.$http.get('http://localhost:8181/student/findAll/'+currentPage+'/5').then(function (resp) {
    //       _this.tableData = resp.data.content
    //       _this.total = resp.data.totalElements
    //     })
    // }
  },
  data () {
    return {
      tableData: null,
      total: null,
      search: ''
    }
  },
}
</script>
