import Vue from 'vue'
import VueRouter from 'vue-router'

import corAdd from '../views/corAdd'
import corMdf from '../views/corMdf'
import corQry from '../views/corQry'
import corQryReadOnly from "../views/corQryReadOnly"
import corQryByTeaWritePartly from "../views/corQryByTeaWritePartly"

import grpAdd from '../views/grpAdd'
import grpMdf from '../views/grpMdf'
import grpQry from '../views/grpQry'
import grpQryByIdReadOnly from "../views/grpQryByIdReadOnly"
import grpBySnumReadOnly from "../views/grpBySnumReadOnly"
import grpStuByTnum from "../views/grpStuByTnum"
import grpQryByTeaWritePartly from "../views/grpQryByTeaWritePartly"
import sgAdd from "../views/sgAdd"

import Login from "../views/Login"
import LogMdf from '../views/LogMdf'
import adm from "../views/adm"
import grptea from "../views/grptea"
import crotea from "../views/crotea"

import scrAdd from '../views/scrAdd'
import scrQry from '../views/scrQry'
import scrMdf from '../views/scrMdf'
import scrQryByIdReadOnly from "../views/scrQryByIdReadOnly"
import scrQryByBanjiReadOnly from "../views/scrQryByBanjiReadOnly"
import scrQryByCorT from "../views/scrQryByCorT"
import scrMdfByCT from "../views/scrMdfByCT"
import scrAddByS from "../views/scrAddByS"

import stuMdf from '../views/stuMdf'
import stuAdd from '../views/stuAdd'
import stuQry from '../views/stuQry'
import student from "../views/student"

import teaAdd from '../views/teaAdd'
import teaMdf from '../views/teaMdf'
import teaQry from '../views/teaQry'
import teaQryReadOnly from '../views/teaQryReadOnly'

import Index from '../views/Index'
import Index_student from '../views/Index_student'
import Index_adm from '../views/Index_adm'
import Index_cort from '../views/Index_cort'
import Index_grpt from '../views/Index_grpt'

import App from '../App'
Vue.use(VueRouter)

const routes = [
  {
    path: '/Login',
    name: "登录",
    show: false,
    component: Login
  },
  {
    path: '/',
    name: "不想展示",
    show: false,
    component: Index,
    children: [
      {
        path: '/teaMdf',
        name: '修改教师',
        show: false,
        component: teaMdf
      },
      {
        path: '/stuMdf',
        name: '修改学生',
        show: false,
        component: stuMdf
      },
      {
        path: '/grpMdf',
        name: '修改班级',
        show: false,
        component: grpMdf
      },
      {
        path: '/corMdf',
        name: '修改课程',
        show: false,
        component: corMdf
      },
      {
        path: '/scrMdf',
        name: '修改成绩',
        show: false,
        component: scrMdf
      },
      {
        path: '/scrMdfByCT',
        name: '修改成绩',
        show: false,
        component: scrMdfByCT
      },
      {
        path: 'Index_student/scrAddByS',
        name: '修改成绩',
        show: false,
        component: scrAddByS
      }
    ]
  },

  {
    path: '/Index_student',
    name: "学生目录",
    show: true,
    component: Index_student,
    children: [
      {
        path: '/Index_student/student',
        name: '个人信息',
        component: student
      },
      {
        path: '/Index_student/teaQryReadOnly',
        name: '教师列表',
        component: teaQryReadOnly
      },
      {
        path: '/Index_studentgrpQryByIdReadOnly',
        name: '班级信息',
        component: grpQryByIdReadOnly
      },
      {
        path: '/Index_student/grpBySnumReadOnly',
        name: '本班同学',
        component: grpBySnumReadOnly
      },
      {
        path: '/Index_student/corQryReadOnly',
        name: '所有课程',
        component: corQryReadOnly
      },
      {
        path: '/Index_student/scrAdd',
        name: '选课',
        component: scrAdd
      },
      {
        path: '/Index_student/scrQryByIdReadOnly',//read only
        name: '我的成绩',
        component: scrQryByIdReadOnly
      },
      {
        path: '/Index_student/LogMdf',
        name: '修改密码',
        component: LogMdf
      }
    ]
  },
  {
    path: '/Index_adm',
    name: "教秘目录",
    show: true,
    component: Index_adm,
    children: [
      {
        path: '/Index_adm/adm',
        name: '个人信息',
        component: adm
      },
      {
        path: '/Index_adm/tea',
        name: '所有教师',
        component: teaQry,
      },
      {
        path: '/Index_adm/teaAdd',
        name: '增加教师',
        component: teaAdd
      },
      {
            path: '/Index_adm/corQty',
            name: '所有课程',
            component: corQry
      },
      {
            path: '/Index_adm/corAdd',
            name: '增加课程',
            component: corAdd
      },
      {

        path: '/Index_adm/grpQry',
        name: '所有班级',
        component: grpQry
      },
      {
        path: '/Index_adm/grpAdd',
        name: '增加班级',
        component: grpAdd
      },
      {
        path: '/Index_adm/sgAdd',
        name: '为班级添加学生',//删除，修改
        component: sgAdd
      },
      {
        path: '/Index_adm/stuQry',
        name: '所有学生',
        component: stuQry
      },
      {
        path: '/Index_admstuAdd',
        name: '增加学生',
        component: stuAdd
      },
      {
        path: '/Index_adm/scrQry',
        name: '所有学生成绩',//,选课，修改成绩
        component: scrQry
      },
      {
        path: '/Index_adm/scrAdd',
        name: '选课',
        component: scrAdd
      },
      {
        path: '/Index_adm/LogMdf',
        name: '修改密码',
        component: LogMdf
      }
    ]
  },
  {
    path: '/Index_grpt',
    name: "班主任目录",
    show: true,
    component: Index_grpt,
    children: [
      {
        path: '/Index_grpt/grptea',
        name: '个人信息',
        component: grptea
      },
      {
        path: '/Index_grpt/teaQryReadOnly',
        name: '教师列表',
        component: teaQryReadOnly
      },
      {
        path: '/Index_grpt/grpQryByTeaWritePartly',//所属于的班级信息，可修改head,life,study
        name: '班级信息',
        component: grpQryByTeaWritePartly
      },
      {
        path: '/Index_grpt/grpStuByTnum',//readOnly
        name: '本班同学',
        component: grpStuByTnum
      },
      {
        path: '/Index_grpt/scrQryByBanjiReadOnly',//成绩查询，成绩统计
        name: '班级成绩',
        component: scrQryByBanjiReadOnly
      },
      {
        path: '/Index_grpt/LogMdf',
        name: '修改密码',
        component: LogMdf
      }
    ]
  },
  {
    path: '/Index_cort',
    name: "任课教师目录",
    show: true,
    component: Index_cort,
    children: [
      {
        path: '/Index_cort/crotea',
        name: '个人信息',
        component: crotea
      },
      {
        path: '/Index_cort/teaQryReadOnly',
        name: '教师列表',
        component: teaQryReadOnly
      },
      {
        path: '/Index_cort/corQryByTeaWritePartly',//我教的课程信息，只能修改课程简介corinfo
        name: '我教的课',
        component: corQryByTeaWritePartly
      },
      {
        path: '/Index_cort/scrQryByCorT',//成绩查询，成绩统计
        name: '选课同学',
        component: scrQryByCorT
      },
      {
        path: '/Index_cort/corQryReadOnly',
        name: '所有课程',
        component: corQryReadOnly
      },
      {
        path: '/Index_cort/LogMdf',
        name: '修改密码',
        component: LogMdf
      }
    ]
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
