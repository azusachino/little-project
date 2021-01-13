export default {
  sidebar: state => state.app.sidebar,
  visitedViews: state => state.tagsView.visitedViews,
  cachedViews: state => state.tagsView.cachedViews,
  token: state => state.user.token,
  user: state => state.user.user,
  roles: state => state.user.roles,
  expireTime: state => state.user.expireTime,
  permissionRoutes: state => state.permission.routes,
  types: state => state.code.types,
  subjects: state => state.code.subjects,
  grades: state => state.code.grades,
  typeMap: state => state.code.typeMap,
  subjectMap: state => state.code.subjectMap,
  gradeMap: state => state.code.gradeMap
}
