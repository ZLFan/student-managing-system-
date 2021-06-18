<template>
  <div>
    <header>我的成绩</header>
    <el-table
        :data="tableData.filter(data => !search || data.cornum.toLowerCase().includes(search.toLowerCase())
                                            ||data.score.toLowerCase().includes(search.toLowerCase())
                           )"
        style="width: 100%">
      <el-table-column
          label="课程号"
          prop="cornum">
      </el-table-column>
      <el-table-column
          label="成绩"
          prop="score">
      </el-table-column>
    </el-table>
  </div>

</template>

<script>
export default {
  created: function () {

    const _this=this

    _this.id=this.$route.query.id
    this.$http.get('http://localhost:8181/sc/findByStunum/'+_this.id).then(function (resp) {
      _this["tableData"] = resp.data
      console.log(resp.data)
      console.log(_this.total)
    })
  },
  methods: {

  },
  data () {
    return {
      ruleForm:{
        cornum: '',
        score: ''
      },
      tableData: null,
      total: null,
      search: ''
    }
  },
}
</script>
