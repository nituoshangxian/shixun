// store.js
import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        // 定义你的状态数据
        ruleForm: {
            yonghuzhanghao: '',
            yonghuxingming: '',
            touxiang: '',
            // 其他初始字段...
        }
    },
    mutations: {
        // 定义修改状态的方法
        UPDATE_RULE_FORM(state, payload) {
            // 正确更新对象的方式
            state.ruleForm = {
                ...state.ruleForm,
                ...payload
            }
        }
    },
    actions: {
        // 定义异步操作
        updateFormData({ commit }, formData) {
            commit('UPDATE_RULE_FORM', formData)
        }
    },
    getters: {
        // 定义获取状态的计算属性
        getFormData: state => state.ruleForm
    }
})