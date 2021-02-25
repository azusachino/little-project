const install = (Vue) => {
    Vue.prototype.$bus = new Vue({
        methods: {
            emit(event, ...args) {
                this.$emit(event, ...args)
            },
            on(event, cb) {
                this.$on(event, cb)
            },
            off(event, cb) {
                this.$off(event, cb)
            }
        },
    })
}

export default install