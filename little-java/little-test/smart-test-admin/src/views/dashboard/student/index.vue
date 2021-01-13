<template>
  <div class="dashboard-editor-container">
    <div class="test-container">
      <el-table></el-table>
    </div>
    <el-row style="background:#fff;padding:16px 16px 0;margin-bottom:32px;">
      <line-chart :chart-data="chartData"/>
    </el-row>
  </div>
</template>

<script>
import LineChart from '@/components/Charts/LineChart'

const chartData = {
  data: ['第一次月考', '第二次月考', '第三次月考', '第四次月考', '第五次月考', '第六次月考', '第七次月考'],
  legend: {
    data: ['语文', '数学']
  },
  series: [
    {
      name: '语文',
      itemStyle: {
        normal: {
          color: '#FF005A',
          lineStyle: {
            color: '#FF005A',
            width: 2
          }
        }
      },
      smooth: true,
      type: 'line',
      data: [120, 82, 91, 154, 162, 140, 145],
      animationDuration: 2800,
      animationEasing: 'cubicInOut'
    },
    {
      name: '数学',
      smooth: true,
      type: 'line',
      itemStyle: {
        normal: {
          color: '#3888fa',
          lineStyle: {
            color: '#3888fa',
            width: 2
          },
          areaStyle: {
            color: '#f3f8ff'
          }
        }
      },
      data: [130, 140, 141, 142, 145, 150, 160],
      animationDuration: 2800,
      animationEasing: 'quadraticOut'
    }
  ]
}
export default {
  name: 'StudentDashboard',
  components: { LineChart },
  data() {
    return {
      chartData
    }
  }
}
</script>

<style lang="scss" scoped>
  .dashboard-editor-container {
    padding: 32px;
    background-color: rgb(240, 242, 245);
    position: relative;
    .test-container {
      margin-bottom: 20px;
    }
  }
</style>
