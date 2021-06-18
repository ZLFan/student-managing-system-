<template>
  <div>
    <header>管理员：教师</header>
    <el-table
        :data="tableData.filter(data => !search || data.teaname.toLowerCase().includes(search.toLowerCase())
                                            ||data.teanum.toLowerCase().includes(search.toLowerCase())
                                            ||data.teaflag.toLowerCase().includes(search.toLowerCase())
                           )"
        style="width: 100%">
      <el-table-column
          label="教师号"
          prop="teanum">
      </el-table-column>
      <el-table-column
          label="教师名"
          prop="teaname">
      </el-table-column>
      <el-table-column
          label="身份证号"
          prop="teaidc">
      </el-table-column>
      <el-table-column
          label="教师身份"
          prop="teaflag">
        <template slot-scope="scope">
          <p v-if="scope.row.teaflag=='0'">
            任课教师
          </p>
          <p v-else-if="scope.row.teaflag=='1'">
            班主任
          </p>
          <p v-else-if="scope.row.teaflag=='2'">
          教秘（管理员）
          </p>
        </template>
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
  </div>

</template>

<script>
export default {
  created: function () {

    const _this=this
    this.$http.get('http://localhost:8181/teacher/findAll').then(function (resp) {
      _this["tableData"] = resp.data
      console.log(resp.data)
      console.log(_this.total)
    })
  },
  methods: {
    edit (row) {
      //console.log(row)
      this.$router.push({
        path: '/teaMdf',
        query: {
          id: row.teanum
        }
      })
      console.log(row.teanum);
    },
    deleteStudent (row){
      this.$http.delete('http://localhost:8181/teacher/deleteById/'+row.teanum).then(function(resp){
        // const _this=this
        // _this.$alert('教师'+row.teanum+'删除成功', 'OK', {
        //   confirmButtonText: '确定',
        //   callback: action => {
        //     //_this.$router.push('/stuQry')//返回查询界面
        //     window.location.reload()//动态刷新查询结果
        //   }
        // })
        this.$http.delete('http://localhost:8181/login/deleteById/'+row.teanum).then(function(resp){
          const _this=this
          _this.$alert('教师'+row.teanum+'删除成功', 'OK', {
            confirmButtonText: '确定',
            callback: action => {
              //_this.$router.push('/stuQry')//返回查询界面
              window.location.reload()//动态刷新查询结果
            }
          })
        })
      })
    }
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
