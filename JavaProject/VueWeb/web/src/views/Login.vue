<template>
  <div>
    <!--flex弹性盒子模型，justify-content：主抽 -->
<!--    <router-link :to="{name:'teaQryOnly', params:{id:this.id}}">Navigate to teaQryOnly</router-link>-->
    <div style="display: flex;justify-content: center;margin-top: 150px">
      <el-card style="width: 400px">
        <div slot="header" class="clearfix">
          <span>登录</span>
        </div>
        <table>
          <tr>
            <td>用户名</td>
            <td>
              <el-input v-model="ruleForm.username" placeholder="请输入用户名"></el-input>
            </td>
          </tr>
          <tr>
            <td>密码</td>
            <td>
              <el-input type="password" v-model="ruleForm.password" placeholder="请输入密码" @keydown.enter.native="doLogin"></el-input>
              <!-- @keydown.enter.native="doLogin"当按下enter键的时候也会执行doLogin方法-->
            </td>
          </tr>
          <tr>
            <!-- 占两行-->
            <td colspan="2">
              <!-- 点击事件的两种不同的写法v-on:click和 @click-->
              <!--<el-button style="width: 300px" type="primary" v-on:click="doLogin">登录</el-button>-->
              <el-button style="width: 300px" type="primary" @click="doLogin">登录</el-button>
            </td>
          </tr>
        </table>
      </el-card>
    </div>
  </div>
</template>
<script>
export default {
  //单页面中不支持前面的data:{}方式
  data() {
    //相当于以前的function data(){},这是es5之前的写法，新版本可以省略掉function
    return{
      //之前是在里面直接写username，password等等，但是这里要写return
      //因为一个组件不管要不要被其他组件用，只要这样定义了，它就会认为可能这个组件会在其他的组件中使用
      //比如说在这里定义了一个变量，然后把这个组件引入到A组件中，A组件中修改了这个变量
      //同时这个组件也在B组件中引用了，这时候A里面一修改，B里面也变了，它们用的是一个值
      //可是一般来说可能希望在不同的组件中引用的时候，使用不同的值，所以这里要用return
      //这样在A组件和B组件分别引用这个变量的时候是不会互相影响的
      ruleForm:{
        username:'1181002038',
        password:'1181002038',
        //为了登录方便，可以直接在这里写好用户名和密码的值
      },
      id:0
    }
  },
  methods:{
    doLogin(){//一点击登录按钮，这个方法就会执行
     // alert(JSON.stringify(this.ruleForm))//可以直接把this.user对象传给后端进行校验用户名和密码
      const _this = this;
      this.$http.get(/*在这里写后端的url/username/password*/"http://localhost:8181/login/test/"+this.ruleForm.username+"/"+this.ruleForm.password)
          .then((resp)=>{
            // alert(resp.data)
        if(resp.data === 0)//任课教师
        {
          this.$message({ type: "success", message: "登录成功" });
          //this.$router.push("/crotea");//任课教师个人界面
          this.$router.push({
            path: '/Index_cort/crotea',
            query: {
              id: this.ruleForm.username
            }
          })
          // alert(id);
        }
        else if(resp.data===1)//班主任
        {
          this.$message({ type: "success", message: "登录成功" });
          //this.$router.push("/grptea");//班主任个人界面
          this.$router.push({
            path: '/Index_grpt/grptea',
            query: {
              id: this.ruleForm.username
            }
          })
        }
        else if(resp.data===2)//教秘
        {
          this.$message({ type: "success", message: "登录成功" });
          //this.$router.push("/adm");//教秘个人界面
          this.$router.push({
            path: '/Index_adm/adm',
            query: {
              id: this.ruleForm.username
            }
          })
        }
        else if(resp.data===3)//学生
        {
          this.$message({ type: "success", message: "登录成功" });
          //this.$router.push("/student");//学生个人界面
          this.$router.push({
            path: '/Index_student/student',
            query: {
              id: this.ruleForm.username
            }
          })
          //alert(this.ruleForm.username)
        }
        else
        {
          this.$message({ type: "error", message: "登录失败" });
        }
      })
    }
    //
  }
}
</script>

