const db = {
  get(key) {
    return JSON.parse(localStorage.getItem(key))
  },
  set(key, val) {
    localStorage.setItem(key, JSON.stringify(val))
  },
  clear() {
    localStorage.clear()
  },
  del(key) {
    localStorage.removeItem(key)
  }
}

export default db
