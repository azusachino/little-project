import Taro from '@tarojs/taro'
import { BASE_URL, HTTP_ERROR } from '../config'

const checkHttpStatus = (res: API.Response, resolve, reject) => {
  if (res.statusCode >= 200 && res.statusCode < 300) {
    resolve(res.data)
  } else {
    const message = HTTP_ERROR[res.statusCode] || `ERROR CODE: ${res.statusCode}`
    res.data.errCode = res.statusCode
    res.data.errMsg = message
    reject(res.data)
  }
}

const setCookie = (res: API.Response) => {
  if (res.cookies && res.cookies.length > 0) {
    let cookies = ''
    res.cookies.forEach((cookie, index) => {
      // windows的微信开发者工具返回的是cookie格式是有name和value的,在mac上是只是字符串的
      if (cookie.name && cookie.value) {
        cookies += index === res.cookies.length - 1 ? `${cookie.name}=${cookie.value};expires=${cookie.expires};path=${cookie.path}` : `${cookie.name}=${cookie.value};`
      } else {
        cookies += `${cookie};`
      }
    })
    Taro.setStorageSync('cookies', cookies)
  }
  if (res.header && res.header['Liz-Bird']) {
    Taro.setStorageSync('cookies', res.header['Liz-Bird'])
  }
  return res
}

export default {
  request(options: any, method?: string) {
    const { url } = options

    return new Promise((resolve, reject) => {
      Taro.request({
        ...options,
        method: method || 'GET',
        url: `${BASE_URL}${url}`,
        header: {
          'content-type': 'application/x-www-form-urlencoded',
          cookie: Taro.getStorageSync('cookies'),
          ...options.header
        }
      }).then(setCookie)
        .then((res) => {
          checkHttpStatus(res, resolve, reject)
        })
    })
  },
  get(options: any) {
    return this.request({
      ...options
    })
  },
  post(options: any) {
    return this.request({
      ...options,
      data: JSON.stringify(options.data)
    }, 'POST')
  },
  put(options: any) {
    return this.request({
      ...options,
      data: JSON.stringify(options.data)
    }, 'PUT')
  },
  delete(options: any) {
    return this.request({
      ...options,
      data: JSON.stringify(options.data)
    }, 'DELETE')
  }

}
