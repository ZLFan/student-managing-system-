<template>
  <div>
    <header>我的班级</header>
    <el-table
        :data="tableData.filter(data => !search || data.stuname.toLowerCase().includes(search.toLowerCase())
                                            ||data.stunum.toLowerCase().includes(search.toLowerCase())
                                            ||data.groupnum.toLowerCase().includes(search.toLowerCase())
                           )"
        style="width: 100%">
      <el-table-column
          label="班级号"
          prop="groupnum">
      </el-table-column>
      <el-table-column
          label="学号"
          prop="stunum">
      </el-table-column>
      <el-table-column
          label="姓名"
          prop="stuname">
      </el-table-column>

      <el-table-column
          align="right">
        <template slot="header" slot-scope="{}">
          <el-input
              v-model="search"
              size="mini"
              placeholder="输入关键字搜索"/>
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

    _this.id=this.$route.query.id
    this.$http.get('http://localhost:8181/sg/findByStunum/'+_this.id).then(function (r) {
      //console.log(r.data[0].groupnum)
      this.$http.get('http://localhost:8181/sg/findByGroupnum/' + r.data[0].groupnum).then(function (resp) {
        //console.log(resp)
        _this.tableData = resp.data
        //alert(this.total)想办法遍历
        for(let i=0;i<38;i++)
        {
          _this.$http.get('http://localhost:8181/student/findById/' +  _this.tableData[i].stunum)
              .then((rr)=> {
                console.log(rr.data.stuname)
                _this.tableData[i].stuname = rr.data.stuname
              })
          //console.log(_this.tableData[i].stuname)
        }
      })
    })
  },
  data () {
    return {
      tableData:null,
      total: null,
      search: '',
      id: null
    }
  }
}
</script>
