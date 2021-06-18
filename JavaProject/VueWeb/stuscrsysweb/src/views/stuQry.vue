<template>
  <div>
    <header>学生操作</header>
  <el-table
    :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
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
      <template slot-scope="{}">
        <el-button
          size="mini"
          @click="handleEdit({}.$index, {}.row)">Edit</el-button>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete({}.$index, {}.row)">Delete</el-button>
      </template>
    </el-table-column>
  </el-table>
  <el-pagination
    background
    layout="prev, pager, next"
    :total="100"
    @current-change="page">
  </el-pagination>
  </div>
</template>

<script>
export default {
  data () {
    return {
      tableData: [{
        stunum: '111111',
        stuname: '王小虎',
        stuidc: '1111111',
        stuyear: 2020,
        stufrom: '上海市'
      }],
      search: ''
    }
  },
  created () {
    alert(999)
    this.axios.get('http://http://localhost:8181/student/findAll').then(function (resp) {
      console.log(resp)
    })
  },
  methods: {
    handleEdit (index, row) {
      console.log(index, row)
    },
    handleDelete (index, row) {
      console.log(index, row)
    },
    page (currentPage) {
      alert(currentPage)
    }
  }
}
</script>
