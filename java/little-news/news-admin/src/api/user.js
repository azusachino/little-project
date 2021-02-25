import request from '../utils/request'

export function login(loginForm) {
  return request.post('/login', loginForm)
}

export function logout() {
  return request.get('/logout')
}
