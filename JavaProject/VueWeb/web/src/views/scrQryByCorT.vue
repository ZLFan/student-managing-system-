<template>
  <div>
    <header>选课同学</header>
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
    <header>成绩统计</header>
    <span> </span>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
    <el-form-item label="及格人数：" prop="passnum">
      <el-input v-model="ruleForm.passnum" readOnly ></el-input>
    </el-form-item>
    </el-form>
    <el-progress :text-inside="true" :stroke-width="30" :percentage=100-unpasspercent status="success"></el-progress>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="不及格人数：" prop="unpassnum">
        <el-input v-model="ruleForm.unpassnum" readOnly ></el-input>
      </el-form-item>
    </el-form>
    <el-progress :text-inside="true" :stroke-width="30" :percentage=unpasspercent status="exception"></el-progress>
  </div>

</template>

<script>
export default {
  created: function () {

    const _this=this
    _this.id=this.$route.query.id
    this.$http.get('http://localhost:8181/course/findByTeanum/'+_this.id)
        .then((r)=>{
      //先找到课程
      //console.log(r)
          this.$http.get('http://localhost:8181/sc/findByCornum/'+r.data[0].cornum)
              .then((resp)=>{
            //再找到成绩
                _this.ruleForm.passnum=0;_this.passpercent=0;
                _this.ruleForm.unpassnum=0;_this.unpasspercent=0;
            console.log(resp)
                var i;
                for(i=0;i<resp.data.length;i++) {
                  _this.tableData.push(resp.data[i]);
                  console.log(i)
                  if(resp.data[i].score<60)
                  {
                    _this.ruleForm.unpassnum=_this.ruleForm.unpassnum+1;
                  }
                  else if(resp.data[i].score>=60)
                  {
                    _this.ruleForm.passnum=_this.ruleForm.passnum+1;
                  }
                }
                _this.passpercent=_this.ruleForm.passnum/i*100;
                _this.unpasspercent=_this.ruleForm.unpassnum/i*100;
                console.log(_this.tableData);
          })
    })


  },
  methods: {
    edit (row) {
      //console.log(row)
      this.$router.push({
        path: '/scrMdfByCT',
        query: {
          id: row.stunum,
          cor:row.cornum
        }
      })
    },
    deleteStudent (row) {
      this.$http.delete('http://localhost:8181/sc/deleteById/' + row.stunum + '/' + row.cornum).then(function (resp) {
        const _this = this
        _this.$alert('课程:' + row.cornum + '\n' + '学生:' + row.stunum + '\n' + '退课成功', 'OK', {
          confirmButtonText: '确定',
          callback: action => {
            window.location.reload()//动态刷新查询结果
          }
        })
      })
    },
    pass(tableData)
    {
      for(let i=0;i<tableData.length;i++)
      {

      }
    }
  },
  data () {
    return {
      ruleForm:{
        passnum: '',
        unpassnum: '',
        score: ''
      },
      tableData: [],
          // {
          //   stunum: '',
          //   cornum: '',
          //   score: ''
          // },
      total: null,
      search: '',
      id: '',
      passnum:'',
      passpercent:'',
      unpassnum:'',
      unpasspercent:''
    }
  },
}
</script>
