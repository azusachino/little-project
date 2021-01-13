import axios from 'axios'
import {MessageBox, Notification} from 'element-ui'
import store from '../store'
import {getToken} from './auth'
import dayjs from 'dayjs'

// 统一配置
const request = axios.create({
  baseURL: process.env.VUE_APP_BASE_API,
  timeout: 5000
})
// 拦截请求
request.interceptors.request.use(
  config => {
    checkExpire()
    // 有 token就带上
    if (store.getters.token) {
      config.headers['SmartToken'] = getToken()
    }
    return config
  }, (error) => {
    console.log('request: ' + error)
    return Promise.reject(error)
  })

// 拦截响应
request.interceptors.response.use(
  res => {
    const {data} = res
    if (data.code !== 200) {
      Notification.warning({
        title: '系统提示',
        message: '很抱歉，发生了未知的错误',
        duration: 3000
      })
    }
    return data
  },
  error => {
    console.log('response: ' + error) // for debug
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

function checkExpire() {
  const expireTime = store.getters.expireTime
  // 让token早10秒种过期，提升“请重新登录”弹窗体验
  if (expireTime) {
    const now = dayjs().format('YYYYMMDDHHmmss')
    if (now - expireTime >= -10) {
      MessageBox.alert('很抱歉，登录已过期，请重新登录', '系统提示', {
        confirmButtonText: '重新登录',
        cancelButtonText: '留在此页',
        type: 'warning'
      })
        .then(() => {
          store.dispatch('user/resetToken').then(() => {
            location.reload()
          })
        })
    }
  }
}

export default request
