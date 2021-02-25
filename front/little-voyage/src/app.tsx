import '@tarojs/async-await'
import Taro, {Component, Config} from '@tarojs/taro'
import { Provider } from '@tarojs/redux'

import dva from './dva'
import Index from './pages/index'
import models from './models'

import './app.scss'

const dvaApp = dva.createApp({
  initialState: {},
  models
})
const store = dvaApp.getStore()

class App extends Component {

  /**
   * 指定config的类型声明为: Taro.Config
   *
   * 由于 typescript 对于 object 类型推导只能推出 Key 的基本类型
   * 对于像 navigationBarTextStyle: 'black' 这样的推导出的类型是 string
   * 提示和声明 navigationBarTextStyle: 'black' | 'white' 类型冲突, 需要显示声明类型
   */
  config: Config = {
    pages: [
      'pages/index/index',
      'pages/account/account'
    ],
    window: {
      backgroundTextStyle: 'light',
      navigationBarBackgroundColor: '#fff',
      navigationBarTitleText: 'WeChat',
      navigationBarTextStyle: 'black',
      enablePullDownRefresh: true
    },
    tabBar: {
      color: '#7A7E83',
      selectedColor: '#c73420',
      borderStyle: 'black',
      backgroundColor: '#fff',
      list: [
        {
          text: '发现',
          pagePath: 'pages/index/index',
          iconPath: 'assets/images/music.png',
          selectedIconPath: 'assets/images/selected-music.png'
        },
        {
          text: '账户',
          pagePath: 'pages/account/account',
          iconPath: 'assets/images/account.png',
          selectedIconPath: 'assets/images/selected-account.png'
        }
      ]
    }
  }

  // 在 App 类中的 render() 函数没有实际作用
  // 请勿修改此函数
  render() {
    return (
      <Provider store={store}>
        <Index/>
      </Provider>
    )
  }
}

Taro.render(<App/>, document.getElementById('app'))
