import request from '../utils/request'

export function login(loginForm) {
  return request({
    url: '/login',
    method: 'post',
    params: loginForm
  })
}

export function getInfo() {
  return request.get('/info')
}

export function logout() {
  return request.get('/logout')
}
