import { login, logout } from '../api/user'
import { resetRouter } from '../router'
import { getToken, removeToken, setToken } from '../utils/auth'
import Cookies from 'js-cookie'
import db from '../utils/localStorage'

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
  SET_USER: (state, user) => {
    state.user = user
    Cookies.set(u, user)
  },
  SET_ROLES: (state, roles) => {
    state.roles = roles
    Cookies.set(r, roles)
  },
  SET_EXPIRE_TIME: (state, expireTime) => {
    state.expireTime = expireTime
    Cookies.set(e, expireTime)
  }
}

const actions = {
  login({ commit }, loginForm) {
    const { username, password } = loginForm
    return new Promise((resolve, reject) => {
      login({ username: username.trim(), password: password })
        .then((res) => {
          const { data } = res
          commit('SET_TOKEN', data.token)
          db.set(u, data.user)
          db.set(r, data.roles)
          db.set(e, data.expireTime)
          resolve()
        })
        .catch((e) => {
          reject(e)
        })
    })
  },
  getInfo({ commit }) {
    return new Promise((resolve, reject) => {
      const user = db.get(u)
      const roles = db.get(r)
      const expireTime = db.get(e)
      commit('SET_USER', user)
      commit('SET_ROLES', roles)
      commit('SET_EXPIRE_TIME', expireTime)
      resolve({ user, roles, expireTime })
        .catch(error => {
          reject(error)
        })
    })
  },
  logout({ commit, state }) {
    return new Promise((resolve, reject) => {
      logout(state.user.id).then(() => {
        commit('SET_TOKEN', '')
        commit('SET_ROLES', [])
        commit('SET_USER', {})
        removeToken()
        Cookies.remove(u)
        Cookies.remove(r)
        db.clear()
        resetRouter()
        resolve()
      }).catch((e) => {
        reject(e)
      })
    })
  },
  resetToken({ commit }) {
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
