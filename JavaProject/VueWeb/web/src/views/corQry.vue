<template>
  <div>
    <header>管理员：课程</header>
    <el-table
        :data="tableData.filter(data => !search || data.corname.toLowerCase().includes(search.toLowerCase())
                                            ||data.cornum.toLowerCase().includes(search.toLowerCase())
                           )"
        style="width: 100%">
      <el-table-column
          label="课程号"
          prop="cornum">
      </el-table-column>
      <el-table-column
          label="课程名"
          prop="corname">
      </el-table-column>
      <el-table-column
          label="开课学期"
          prop="corterm">
      </el-table-column>
      <el-table-column
          label="课程简介"
          prop="corinfo">
      </el-table-column>
      <el-table-column
          label="学分"
          prop="corcredit">
      </el-table-column>
      <el-table-column
          label="任课教师"
          prop="teanum">
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
    this.$http.get('http://localhost:8181/course/findAll').then(function (resp) {
       _this.tableData=resp.data
      // console.log("resp.data.cornum:"+resp.data.cornum)
      // this.$http.get('http://localhost:8181/tc/findByCornum/'+this.tableData.cornum).then(function (res) {
      //   _this.tableData.teanum=res.data.teanum
      //  //alert(res.data);
      //    console.log("res.data:"+res.data)
      //   // console.log(_this.total)
      //})
    })

  },
  methods: {
    edit (row) {
      //console.log(row)
      this.$router.push({
        path: '/corMdf',
        query: {
          id: row.cornum
        }
      })
      console.log(row.cornum);
    },
    deleteStudent (row){
      this.$http.delete('http://localhost:8181/course/deleteById/'+row.cornum).then(function(resp){
        const _this=this
        _this.$alert('课程'+row.cornum+'删除成功', 'OK', {
          confirmButtonText: '确定',
          callback: action => {
            //_this.$router.push('/stuQry')//返回查询界面
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
      tableData:
    {
      cornum: '',
      corname: '',
      corterm: '',
      corinfo: '',
      corcredit: '',
      teanum:''
    },
      total: null,
      search: ''
    }
  },
}
</script>
