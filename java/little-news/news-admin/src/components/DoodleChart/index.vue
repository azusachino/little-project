<template>
  <svg :config="config" :id="id" :class="className">
  </svg>
</template>

<script>
import chartXkcd from 'chart.xkcd'
/* 考虑如何复用 */
export default {
  name: 'DoodleChart',
  props: {
    id: {
      type: String,
      default: 'chart'
    },
    className: {
      type: String,
      default: 'chart'
    },
    config: {
      type: Object
    }
  },
  data() {
    return {
      chart: null
    }
  },
  methods: {
    initChart() {
      this.chart = new chartXkcd.XY({})
    }
  }
}
</script>

<style scoped>

</style>
