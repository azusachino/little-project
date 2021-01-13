<template>
  <div>
    <el-scrollbar wrap-class="scrollbar-wrapper">
      <el-menu
        :default-active="activeMenu"
        :collapse="isCollapse"
        :background-color="bgColor"
        :text-color="txtColor"
        :unique-opened="false"
        :active-text-color="aTxtColor"
        :collapse-transition="false"
        mode="vertical">
        <side-bar-item
          v-for="route in permissionRoutes"
          :key="route.path"
          :item="route"
          :base-path="route.path"/>
      </el-menu>
    </el-scrollbar>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import SideBarItem from './SideBarItem'

export default {
  name: 'SideBar',
  components: { SideBarItem },
  data() {
    return {
      bgColor: '#304156',
      txtColor: '#bfcbd9',
      aTxtColor: '#409EFF'
    }
  },
  computed: {
    ...mapGetters([
      'sidebar',
      'permissionRoutes'
    ]),
    activeMenu() {
      const route = this.$route
      const { meta, path } = route
      // if set path, the sidebar will highlight the path you set
      if (meta.activeMenu) {
        return meta.activeMenu
      }
      return path
    },
    isCollapse() {
      return !this.sidebar.opened
    }
  }
}
</script>

<style scoped>

</style>
