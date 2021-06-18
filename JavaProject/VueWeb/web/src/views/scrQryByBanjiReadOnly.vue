<template>
  <div>
    <header>班级成绩</header>
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
    </el-table>
  </div>

</template>

<script>
export default {
  created: function () {

    const _this=this
    _this.id=this.$route.query.id
    var j=0;
    this.$http.get('http://localhost:8181/banji/findByTeanum/'+_this.id)
        .then((r)=>{
      //先找到班级
      //console.log(r)
          this.$http.get('http://localhost:8181/sg/findByGroupnum/'+r.data.groupnum)
              .then((resp)=>{
            //再找到学生
           // console.log(resp)
            for(let i=0;i<resp.data.length;i++)
            {
              //最后找到成绩
              //console.log(resp.data[i].stunum)
              this.$http.get('http://localhost:8181/sc/findByStunum/'+resp.data[i].stunum)
                  .then((rr) =>{
                //console.log(rr)
                if(rr.data.length!=0) {
                  var num=rr.data.length;
                  for(let k=0;k <num;k++)
                  {
                    console.log(_this.tableData);
                    _this.tableData.push(rr.data[k]);
                    j=j+1;
                  }
                  console.log("跳出循环");
                  console.log(_this.tableData);
                }
              })
            }
          })
    })
    console.log(this.tableData);

  },
  methods: {

  },
  data () {
    return {
      // ruleForm:{
      //   cornum: '',
      //   stunum: '',
      //   score: ''
      // },
      tableData: [],
          // {
          //   stunum: '',
          //   cornum: '',
          //   score: ''
          // },
      total: null,
      search: '',
      id: ''
    }
  },
}
</script>
