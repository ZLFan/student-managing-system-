import Vue from 'vue'
import VueRouter from 'vue-router'
import corAdd from '../views/corAdd'
import corDel from '../views/corDel'
import corMdf from '../views/corMdf'
import corQry from '../views/corQry'
import grpAdd from '../views/grpAdd'
import grpDel from '../views/grpDel'
import grpDelStu from '../views/grpDelStu'
import grpAddStu from '../views/grpAddStu'
import grpMdf from '../views/grpMdf'
import grpQry from '../views/grpQry'
import LogMdf from '../views/LogMdf'
import scrAdd from '../views/scrAdd'
import scrDel from '../views/scrDel'
import scrQry from '../views/scrQry'
import scrRank from '../views/scrRank'
import stuMdf from '../views/stuMdf'
import scrMdf from '../views/scrMdf'
import stuQry from '../views/stuQry'
import teaMdf from '../views/teaMdf'
import teaQry from '../views/teaQry'
import Index from '../views/Index'
import App from '../App'
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: '学生管理',
    component: Index,
    children: [
      {
        path: '/stuMdf',
        name: '修改学生',
        component: stuMdf
      },
      {
        path: '/stuQry',
        name: '查询学生',
        component: stuQry
      }
    ]
  },
  {
    path: '/',
    name: '班级管理',
    component: Index,
    children: [
      {
        path: 'grpAdd',
        name: '增加班级',
        component: grpAdd
      },
      {
        path: 'grpDel',
        name: '删除班级',
        component: grpDel
      },
      {
        path: '/grpAddStu',
        name: '为班级新增学生',
        component: grpAddStu
      },
      {
        path: '/grpDelStu',
        name: '为班级删除学生',
        component: grpDelStu
      },
      {
        path: '/grpMdf',
        name: '修改班级',
        component: grpMdf
      },
      {
        path: '/grpQry',
        name: '查询班级',
        component: grpQry
      }
    ]

  },
  {
    path: '/',
    name: '教师管理',
    component: Index,
    children: [
      {
        path: '/teaMdf',
        name: '修改教师',
        component: teaMdf
      },
      {
        path: '/teaQry',
        name: '查询教师',
        component: teaQry
      }
    ]

  },
  {
    path: '/',
    name: '课程管理',
    component: Index,
    children: [
      {
        path: '/corAdd',
        name: '增加课程',
        component: corAdd
      },
      {
        path: '/corDel',
        name: '删除课程',
        component: corDel
      },
      {
        path: '/corMdf',
        name: '修改课程',
        component: corMdf
      },
      {
        path: '/corQry',
        name: '查询课程',
        component: corQry
      }
    ]

  },
  {
    path: '/',
    name: '成绩管理',
    component: Index,
    children: [
      {
        path: '/scrAdd',
        name: '选课',
        component: scrAdd
      },
      {
        path: '/scrDel',
        name: '退课',
        component: scrDel
      },
      {
        path: '/scrQry',
        name: '查询成绩',
        component: scrQry
      },
      {
        path: '/scrRank',
        name: '查看排名',
        component: scrRank
      },
      {
        path: '/scrMdf',
        name: '修改成绩',
        component: scrMdf
      }
    ]

  },
  {
    path: '/',
    name: '登录管理',
    component: Index,
    children: [
      {
        path: '/LogMdf',
        name: '修改密码',
        component: LogMdf
      }
    ]
  },
  {
    path: 'App',
    name: 'App',
    component: App
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
