<template>
  <svg :config="config"></svg>
</template>

<script>
import chartXkcd from 'chart.xkcd'

export default {
  name: 'LineChart',
  props: {
    config: Object
  },
  mounted() {
    this.init()
  },
  methods: {
    init() {
      return new chartXkcd.Line(this.$el, this.config)
    }
  }
}
</script>

<style scoped>

</style>
