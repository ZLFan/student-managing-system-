<template>
  <div>
    <header>管理员：学生</header>
  <el-table
    :data="tableData.filter(data => !search || data.stuname.toLowerCase().includes(search.toLowerCase())
                                            ||data.stunum.toLowerCase().includes(search.toLowerCase())
                                            ||data.stufrom.toLowerCase().includes(search.toLowerCase())
                           )"
    style="width: 100%">
    <el-table-column
      label="学号"
      prop="stunum">
    </el-table-column>
    <el-table-column
      label="姓名"
      prop="stuname">
    </el-table-column>
    <el-table-column
      label="身份证号"
      prop="stuidc">
    </el-table-column>
    <el-table-column
      label="入学年份"
      prop="stuyear">
    </el-table-column>
    <el-table-column
      label="生源地"
      prop="stufrom">
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
          @click="deleteStudent (scope.row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
<!--  <el-pagination-->
<!--    background-->
<!--    layout="prev, pager, next"-->
<!--    :total="total"-->
<!--    :page-size="5"-->
<!--    @current-change="page">-->
<!--  </el-pagination>-->
  </div>

</template>

<script>
export default {
  created: function () {

    const _this=this
    this.$http.get('http://localhost:8181/student/findAll').then(function (resp) {
      _this["tableData"] = resp.data
      console.log(resp.data)
      console.log(_this.total)
    })
  },
  methods: {
    edit (row) {
      //console.log(row)
      this.$router.push({
         path: '/stuMdf',
        query: {
          id: row.stunum
        }
      })
      console.log(row.stunum);
    },
    deleteStudent (row){
      this.$http.delete('http://localhost:8181/student/deleteById/'+row.stunum).then(function(resp){
          // const _this=this
          // _this.$alert('学生'+row.stunum+'删除成功', 'OK', {
          //   confirmButtonText: '确定',
          //   callback: action => {
          //     //_this.$router.push('/stuQry')//返回查询界面
          //     window.location.reload()//动态刷新查询结果
          //   }
          // })
        this.$http.delete('http://localhost:8181/login/deleteById/'+row.stunum).then(function(resp){
          const _this=this
          _this.$alert('学生'+row.stunum+'删除成功', 'OK', {
            confirmButtonText: '确定',
            callback: action => {
              //_this.$router.push('/stuQry')//返回查询界面
              window.location.reload()//动态刷新查询结果
            }
          })
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
