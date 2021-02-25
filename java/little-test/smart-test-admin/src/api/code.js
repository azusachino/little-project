import request from '../utils/request'

export function getCode() {
  return request.get('/code')
}
