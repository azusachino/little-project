import ctors from './constructor'
import create from './create'

export default function install(Vue) {
  for (const name in ctors) {
    const component = create(name)
    component && Vue.component(name, component)
  }
}

if (typeof window !== 'undefined' && window.Vue && window.chartXkcd) {
  install(window.Vue)
}

const chartXKCDLine = create('chartxkcd-line')
const chartXKCDBar = create('chartxkcd-bar')
const chartXKCDXY = create('chartxkcd-xy')
const chartXKCDPie = create('chartxkcd-pie')
const chartXKCDRadar = create('chartxkcd-radar')

export {
  create as genComponent,
  chartXKCDLine,
  chartXKCDBar,
  chartXKCDXY,
  chartXKCDPie,
  chartXKCDRadar
}
