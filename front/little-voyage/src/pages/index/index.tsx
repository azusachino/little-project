import Taro, { Component, Config } from '@tarojs/taro'
import { View } from '@tarojs/components'
import './index.scss'

interface TabItem {
  id: number,
  title: string
}

interface IndexStates {
  activeTab: number,
  tabs: TabItem[]
}

const tabs: TabItem[] = [
  {id: 0, title: 'AcgDoge'},
  {id: 1, title: '2dj'}
]

export default class Index extends Component<{}, IndexStates> {
  state = {
    activeTab: 0,
    tabs: [...tabs]
  }

  componentWillMount () { }

  componentDidMount () { }

  componentWillUnmount () { }

  componentDidShow () { }

  componentDidHide () { }

  onPullDownRefresh(): void {
    this.refresh()
  }

  switchTab(index, init) {
    if (this.state.activeTab === index && !init) { return }
    this.setState({activeTab : index})
    switch (index) {
      case 0 :
      case 1:
      case 2:
      default:
        break
    }
  }

  refresh() {
    const activeTab = this.state.activeTab
    switch(activeTab) {
      case 0 :
      case 1:
      case 2:
      default:
        break
    }
  }

  /**
   * 指定config的类型声明为: Taro.Config
   *
   * 由于 typescript 对于 object 类型推导只能推出 Key 的基本类型
   * 对于像 navigationBarTextStyle: 'black' 这样的推导出的类型是 string
   * 提示和声明 navigationBarTextStyle: 'black' | 'white' 类型冲突, 需要显示声明类型
   */
  config: Config = {
    navigationBarTitleText: '首页'
  }

  render () {
    return (
      <View className='wrapper index-wrapper'>
        <View className='home-wrapper'>
          <View className='index-tab'>
            {this.state.tabs.map((data, n) => {
              return (
                <View key={n} className={`tab ${this.state.activeTab === n ? 'cur' : ''}`} onClick={this.switchTab.bind(this,n)}>
                  {data.title}
                </View>
              )
            })}
          </View>
          <View className='home-tab-wrapper'>
            <View className='swipe-wrapper'>
              <View className='swipe-slide' hidden={this.state.activeTab !== 0}>

              </View>
              <View className='swipe-slide' hidden={this.state.activeTab !== 1}>

              </View>
              <View className='swipe-slide' hidden={this.state.activeTab !== 2}>

              </View>
            </View>
          </View>
        </View>
      </View>
    )
  }
}
