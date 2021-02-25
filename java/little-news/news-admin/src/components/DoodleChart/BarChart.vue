<template>
  <svg></svg>
</template>

<script>
import chartXkcd from 'chart.xkcd'

export default {
  name: 'BarChart',
  props: {
    config: Object
  },
  mounted() {
    this.init()
  },
  methods: {
    init() {
      return new chartXkcd.Bar(this.$el, this.config)
    }
  }
}
</script>

<style scoped>

</style>
