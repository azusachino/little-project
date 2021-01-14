import Taro from '@tarojs/taro'
import { login } from './api'

export const wxLogin = async () => {
  try {
    const res = await Taro.login()
    return res.code
  } catch (e) {
    console.log('err occurred when getting wx credit')
  }
}

export const userLogin = async () => {
  try {
    await Taro.checkSession()
    if (!Taro.getStorageSync('token')) {
      throw new Error('no token locally')
    }
  } catch (e) {
    const code = await wxLogin()
    const loginRes: any = await login({
      code
    })
    console.log('user info', loginRes)
  }
}
