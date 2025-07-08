import Vue from 'vue'
import Vuex from 'vuex'
import tagsView from './modules/tagsView'

Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
    tagsView,
  },
  strict: process.env.NODE_ENV !== 'production'
})

export default store
