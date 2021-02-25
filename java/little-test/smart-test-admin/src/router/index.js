import Vue from 'vue'
import Router from 'vue-router'
/* Layout */
import Layout from '../layout/index'

Vue.use(Router)

export const constantRoutes = [
  {
    path: '/redirect',
    component: Layout,
    hidden: true,
    children: [
      {
        path: '/redirect/:path',
        component: () => import('../views/redirect/index')
      }
    ]
  },
  {
    path: '/login',
    component: () => import('../views/login/index'),
    hidden: true
  },
  {
    path: '/auth-redirect',
    component: () => import('../views/login/auth-redirect'),
    hidden: true
  },
  {
    path: '/404',
    component: () => import('../views/error-page/404'),
    hidden: true
  },
  {
    path: '/401',
    component: () => import('../views/error-page/401'),
    hidden: true
  },
  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [
      {
        path: 'dashboard',
        component: () => import('../views/dashboard/index'),
        name: 'Dashboard',
        meta: {title: '主页', icon: 'dashboard', affix: true}
      }
    ]
  },
  {
    path: '/profile',
    component: Layout,
    redirect: '/profile/index',
    hidden: true,
    children: [
      {
        path: 'index',
        component: () => import('../views/dashboard/index'),
        name: 'profile',
        meta: {
          title: '个人中心',
          icon: 'user',
          noCache: true
        }
      }
    ]
  }
]

/**
 * asyncRoutes
 * the routes that need to be dynamically loaded based on user roles
 */
export const asyncRoutes = [
  {
    path: '/quest',
    component: Layout,
    redirect: '/quest/list',
    name: 'quest',
    meta: {
      title: '试题管理',
      icon: 'pdf',
      roles: ['teacher']
    },
    children: [
      {
        path: 'list',
        component: () => import('../views/quest/list'),
        name: 'questList',
        meta: {
          title: '试题列表',
          roles: ['teacher']
        }
      }
    ]
  },
  {
    path: '/paper',
    component: Layout,
    redirect: '/paper/list',
    name: 'paper',
    meta: {
      title: '试卷管理',
      icon: 'list',
      roles: ['teacher']
    },
    children: [
      {
        path: 'list',
        component: () => import('../views/paper/list'),
        name: 'paperList',
        meta: {
          title: '试卷列表',
          roles: ['teacher']
        }
      },
      {
        path: 'detail',
        component: () => import('../views/paper/detail'),
        name: 'paperDetail',
        meta: {
          title: '试卷详情',
          roles: ['teacher']
        }
      }
    ]
  },
  {
    path: '/test',
    component: Layout,
    redirect: '/test/list',
    name: 'test',
    meta: {
      title: '考试管理',
      icon: 'edit',
      roles: ['teacher']
    },
    children: [
      {
        path: 'list',
        component: () => import('../views/test/list'),
        name: 'testList',
        meta: {
          title: '考试列表',
          roles: ['teacher']
        }
      }
    ]
  },
  {
    path: '/user',
    component: Layout,
    redirect: '/user/list',
    name: 'user',
    meta: {
      title: '人员管理',
      icon: 'people',
      roles: ['admin']
    },
    children: [
      {
        path: 'list',
        component: () => import('../views/user/list'),
        name: 'userList',
        meta: {
          title: '人员列表',
          roles: ['admin']
        }
      }
    ]
  },
  {
    path: '/class',
    component: Layout,
    redirect: '/class/list',
    name: 'class',
    meta: {
      title: '班级管理',
      icon: 'peoples',
      roles: ['admin']
    },
    children: [
      {
        path: 'list',
        component: () => import('../views/class/list'),
        name: 'classList',
        meta: {
          title: '班级列表',
          roles: ['admin']
        }
      }
    ]
  },
  {
    path: '/subject',
    component: Layout,
    redirect: '/subject/list',
    name: 'subject',
    meta: {
      title: '课程管理',
      icon: 'excel',
      roles: ['admin']
    },
    children: [
      {
        path: 'list',
        component: () => import('../views/subject/list'),
        name: 'subjectList',
        meta: {
          title: '课程列表',
          roles: ['admin']
        }
      }
    ]
  },
  {
    path: '/score',
    component: Layout,
    redirect: '/score/list',
    name: 'score',
    meta: {
      title: '分数查询',
      icon: 'form',
      roles: ['student']
    },
    children: [
      {
        path: 'list',
        component: () => import('../views/score/list'),
        name: 'scoreList',
        meta: {
          title: '分数列表',
          roles: ['student']
        }
      }
    ]
  },
  {
    path: '/exam',
    component: Layout,
    redirect: '/exam/index',
    name: 'exam',
    hidden: true,
    meta: {
      roles: ['teacher', 'student']
    },
    children: [
      {
        path: 'index',
        component: () => import('../views/exam/index'),
        meta: {
          roles: ['teacher', 'student']
        }
      }
    ]
  },
  // 404 must be placed at the end !!!
  {path: '*', redirect: '/404', hidden: true}
]

const createRouter = () => new Router({
  routes: constantRoutes
})

const router = createRouter()

export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher
}

export default router
