import { create } from 'dva-core'
import createLoading from 'dva-loading'

let app
let store
let dispatch
let registered

function createApp(options?: any) {
  const { models } = options

  app = create({
    ...options
  })
  app.use(createLoading({}))
  if (!registered) {
    models.forEach((model) => app.model(model))
  }
  registered = true
  app.start()

  store = app._store
  app.getStore = () => store

  dispatch = store.dispatch
  app.dispatch = dispatch
  return app
}

export default {
  createApp,
  getDispatch() {
    return app.dispatch
  }
}
