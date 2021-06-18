<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<style>
.el-header {
  background-color: #B3C0D1;
  color: #333;
  line-height: 60px;
}

.el-aside {
  color: #333;
}
</style>

<script>
export default {
  data () {
    const item = {
      stunum: '111111',
      stuname: '王小虎',
      stuidc: '1111111',
      stuyear: 2020,
      stufrom: '上海市'
    }
    return {
      tableData: Array(20).fill(item)
    }
  }
}
</script>
