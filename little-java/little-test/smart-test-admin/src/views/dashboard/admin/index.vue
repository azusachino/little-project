<template>
  <div class="dashboard-editor-container">
    <panel-group @handleSetChartData="handleSetChartData"/>
    <el-row style="background: #fff;padding: 16px 16px 0;margin-bottom: 32px;">
    </el-row>
  </div>
</template>

<script>
import PanelGroup from './components/PanelGroup'

const chartData = {
  question: {
    currentData: [100, 120, 161, 134, 105, 160, 165]
  },
  paper: {
    currentData: [200, 192, 120, 144, 160, 130, 140]
  },
  test: {
    currentData: [80, 100, 121, 104, 105, 90, 100]
  },
  user: {
    currentData: [130, 140, 141, 142, 145, 150, 160]
  }
}

export default {
  name: 'AdminDashboard',
  components: { PanelGroup },
  data() {
    return {
      chartData: chartData.question
    }
  },
  methods: {
    handleSetChartData(type) {
      this.chartData = chartData[type]
    }
  }
}
</script>

<style lang="scss" scoped>
  .dashboard-editor-container {
    padding: 32px;
    background-color: rgb(240, 242, 245);
    position: relative;

    .chart-wrapper {
      background: #fff;
      padding: 16px 16px 0;
      margin-bottom: 32px;
    }
  }

  @media (max-width: 1024px) {
    .chart-wrapper {
      padding: 8px;
    }
  }
</style>
