import {getInfo, login, logout} from '../../api/user'
import {resetRouter} from '../../router'
import {getToken, removeToken, setToken} from '../../utils/auth'
import db from '../../utils/localStorage'
import {Message} from 'element-ui'

const u = 'USER'
const r = 'ROLES'
const e = 'EXPIRE_TIME'

const state = {
  token: getToken(),
  user: {},
  roles: [],
  expireTime: ''
}

const mutations = {
  SET_TOKEN: (state, token) => {
    state.token = token
    setToken(token)
  },
  SET_EXPIRE_TIME: (state, expireTime) => {
    state.expireTime = expireTime
    db.set(e, expireTime)
  },
  SET_USER: (state, user) => {
    state.user = user
    db.set(u, user)
  },
  SET_ROLES: (state, roles) => {
    state.roles = roles
    db.set(r, roles)
  }
}

const actions = {
  login({commit}, loginForm) {
    const {loginId, password} = loginForm
    return new Promise((resolve, reject) => {
      login({loginId, password})
        .then((res) => {
          const {token, expireTime} = res
          commit('SET_TOKEN', token)
          commit('SET_EXPIRE_TIME', expireTime)
          Message.success({
            message: res.message,
            duration: 2000
          })
          resolve()
        })
        .catch((e) => {
          reject(e)
        })
    })
  },
  getInfo({commit}) {
    return new Promise((resolve, reject) => {
      getInfo()
        .then((res) => {
          if (!res) {
            reject(new Error('Verification failed'))
          }
          const {user, roles} = res
          if (!roles || roles.length <= 0) {
            reject(new Error('something went wrong, 角色管理'))
          }
          commit('SET_USER', user)
          commit('SET_ROLES', roles)
          resolve(res)
        })
        .catch(error => {
          reject(error)
        })
    })
  },
  logout({commit}) {
    return new Promise((resolve, reject) => {
      logout().then(() => {
        commit('SET_TOKEN', '')
        commit('SET_ROLES', [])
        commit('SET_USER', {})
        removeToken()
        resetRouter()
        resolve()
      }).catch((e) => {
        reject(e)
      })
    })
  },
  resetToken({commit}) {
    return new Promise(resolve => {
      commit('SET_TOKEN', '')
      commit('SET_ROLES', [])
      commit('SET_USER', {})
      resolve()
    })
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}
