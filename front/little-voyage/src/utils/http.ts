import Taro from '@tarojs/taro'


type HttpMethods = 'GET' | 'POST' | 'DELETE' | 'PUT'

const contentType = 'application/x-www-form-urlencoded'

export default class Http {

  get(url: string, data: object) {
    return this.commonHttp('GET', url, data)
  }

  post(url: string, data: object) {
    return this.commonHttp('POST', url, data)
  }


  async commonHttp(method: HttpMethods, url: string, data: object) {
    return new Promise<any>(async (resolve, reject) => {
      Taro.showNavigationBarLoading()
      try {
        const res = await Taro.request({
          url, method, data, header: {
            'content-type': contentType
          }
        })
        Taro.hideNavigationBarLoading()
        switch (res.statusCode) {
          case 200:
            return resolve(res.data.message)
          default:
            console.log(res.data.message)
            reject(new Error(res.data.message))
        }
      } catch (e) {
        Taro.hideNavigationBarLoading()
        reject(new Error('network error'))
      }
    })
  }
}
