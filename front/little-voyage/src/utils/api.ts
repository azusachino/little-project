import Http from './http'


const http = new Http()

const url = 'xxx'

export const login = (data: object) => http.post(url, data)
