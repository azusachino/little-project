import axios from 'axios'
import { MessageBox, Notification } from 'element-ui'
import store from '../store'
import { getToken } from './auth'
import dayjs from 'dayjs'

// 统一配置
const service = axios.create({
  baseURL: 'http://localhost:8088/api/v1/',
  responseType: 'json',
  validateStatus(status) {
    // 200 外的状态码都认定为失败
    return status === 200
  }
})
// 拦截请求
service.interceptors.request.use((config) => {
  const expireTime = store.getters.expireTime
  const now = dayjs().format('YYYYMMDDHHmmss')
  // 让token早10秒种过期，提升“请重新登录”弹窗体验

  if (expireTime - now <= 10) {
    MessageBox.alert('很抱歉，登录已过期，请重新登录', '登录已过期', {
      confirmButtonText: '重新登录',
      cancelButtonText: '返回首页',
      type: 'warning'
    })
      .then(() => {
        store.dispatch('user/resetToken').then(() => {
          location.reload()
        })
      })
  }

  // 有 token就带上
  if (store.getters.token) {
    config.headers['Liz&BlueBird'] = getToken()
  }
  return config
}, (error) => {
  return Promise.reject(error)
})

// 拦截响应
service.interceptors.response.use((config) => {
  return config
}, (error) => {
  if (error.response) {
    const errorMessage = error.response.data === null ? '系统内部异常，请联系网站管理员' : error.response.data.message
    switch (error.response.status) {
      case 404:
        Notification.warning({
          title: '系统提示',
          message: '很抱歉，资源未找到',
          duration: 3000
        })
        break
      case 403:
      case 401:
        Notification.warning({
          title: '系统提示',
          message: '很抱歉，您无法访问该资源，可能是因为没有相应权限或者登录已失效',
          duration: 3000
        })
        break
      default:
        Notification.warning({
          title: '系统提示',
          message: errorMessage,
          duration: 3000
        })
        break
    }
  }
  return Promise.reject(error)
})

export default service
