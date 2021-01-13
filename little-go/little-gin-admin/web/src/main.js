import Vue from 'vue'
import App from './App.vue'
// 引入element
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
// 引入封装的router
import router from '@/router/index'
// canvas背景插件
import vueParticleLine from 'vue-particle-line'
import 'vue-particle-line/dist/vue-particle-line.css'
// time line css
import '../node_modules/timeline-vuejs/dist/timeline-vuejs.css'
// 富文本插件
import VueQuillEditor from 'vue-quill-editor'
import 'quill/dist/quill.core.css'
import 'quill/dist/quill.snow.css'
import 'quill/dist/quill.bubble.css'
// markdown插件
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
import '@/permission'
import {store} from '@/store/index'
// 路由守卫
import Bus from '@/utils/bus.js'
import APlayer from '@moefe/vue-aplayer';
import {auth} from '@/directive/auth'
//引入echarts
import echarts from 'echarts'
// 全局配置elementui的dialog不能通过点击遮罩层关闭
ElementUI.Dialog.props.closeOnClickModal.default = false
Vue.use(ElementUI);

Vue.use(vueParticleLine)

Vue.use(VueQuillEditor)

Vue.use(mavonEditor)

Vue.config.productionTip = false

Vue.use(Bus)

Vue.use(APlayer, {
    defaultCover: 'https://github.com/u3u.png',
    productionTip: true,
});


// 按钮权限指令
auth(Vue)


new Vue({
    render: h => h(App),
    router,
    store
}).$mount('#app')

Vue.prototype.$echarts = echarts;
