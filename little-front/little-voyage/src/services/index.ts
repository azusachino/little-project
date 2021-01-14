import API from './api'

// 获取用户信息
export function getUserDetail(uid: number) {
  return API.get({
    url: '/user/detail',
    data: {
      uid
    }
  })
}

