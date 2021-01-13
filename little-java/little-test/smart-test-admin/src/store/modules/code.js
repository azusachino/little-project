import {getCode} from '../../api/code'
import db from '../../utils/localStorage'

const state = {
  types: db.get('types'),
  subjects: db.get('subjects'),
  grades: db.get('grades'),
  typeMap: db.get('typeMap'),
  subjectMap: db.get('subjectMap'),
  gradeMap: db.get('gradeMap')
}

const mutations = {
  SET_TYPES: (state, types) => {
    state.types = types
    state.typeMap = objs2Map(types)
    db.set('types', types)
    db.set('typeMap', objs2Map(types))
  },
  SET_SUBJECTS: (state, subjects) => {
    state.subjects = subjects
    state.subjectMap = objs2Map(subjects)
    db.set('subjects', subjects)
    db.set('subjectMap', objs2Map(subjects))
  },
  SET_GRADES: (state, grades) => {
    state.grades = grades
    state.gradeMap = objs2Map(grades)
    db.set('grades', grades)
    db.set('gradeMap', objs2Map(grades))
  }
}

const actions = {
  getCode({commit}) {
    return new Promise((resolve, reject) => {
      getCode()
        .then((res) => {
          if (res == null) {
            reject(new Error('获取code失败'))
          }
          const {types, subjects, grades} = res
          commit('SET_TYPES', types)
          commit('SET_SUBJECTS', subjects)
          commit('SET_GRADES', grades)
        })
        .catch((e) => {
          console.error(e)
        })
    })
  }
}

function objs2Map(objects) {
  const map = new Map()
  for (const obj of objects) {
    for (const k of Object.keys(obj)) {
      map.set(k, obj[k])
    }
  }
  return map
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}
