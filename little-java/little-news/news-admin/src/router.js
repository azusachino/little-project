import Vue from 'vue'
import Router from 'vue-router'
/* Layout */
import Layout from './layout'

Vue.use(Router)

export const constantRoutes = [
  {
    path: '/redirect',
    component: Layout,
    hidden: true,
    children: [
      {
        path: '/redirect/:path',
        component: () => import('./views/redirect')
      }
    ]
  },
  {
    path: '/login',
    component: () => import('./views/login'),
    hidden: true
  },
  {
    path: '/auth-redirect',
    component: () => import('./views/login/auth-redirect'),
    hidden: true
  },
  {
    path: '/404',
    component: () => import('./views/error-page/404'),
    hidden: true
  },
  {
    path: '/401',
    component: () => import('./views/error-page/401'),
    hidden: true
  },
  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [
      {
        path: 'dashboard',
        component: () => import('./views/dashboard'),
        name: 'Dashboard',
        meta: { title: 'Dashboard', icon: 'dashboard', affix: true }
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
        component: () => import('./views/dashboard'),
        name: 'profile',
        meta: {
          title: 'Profile',
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
  // 404 must be placed at the end !!!
  { path: '*', redirect: '/404', hidden: true }
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
