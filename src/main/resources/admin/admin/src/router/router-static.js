import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import news from '@/views/modules/news/list'
    import fuwuzhipai from '@/views/modules/fuwuzhipai/list'
    import yonghu from '@/views/modules/yonghu/list'
    import yishengzixun from '@/views/modules/yishengzixun/list'
    import shangmenshenqing from '@/views/modules/shangmenshenqing/list'
    import shequyisheng from '@/views/modules/shequyisheng/list'
    import keshi from '@/views/modules/keshi/list'
    import jiankangpingce from '@/views/modules/jiankangpingce/list'
    import tijianbaogao from '@/views/modules/tijianbaogao/list'
    import jiankangxinxi from '@/views/modules/jiankangxinxi/list'
    import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
    path: '/',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center', affix: true}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/news',
        name: '健康资讯',
        component: news
      }
      ,{
	path: '/fuwuzhipai',
        name: '服务指派',
        component: fuwuzhipai
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/yishengzixun',
        name: '医生咨询',
        component: yishengzixun
      }
      ,{
	path: '/shangmenshenqing',
        name: '上门申请',
        component: shangmenshenqing
      }
      ,{
	path: '/shequyisheng',
        name: '社区医生',
        component: shequyisheng
      }
      ,{
	path: '/keshi',
        name: '科室',
        component: keshi
      }
      ,{
	path: '/jiankangpingce',
        name: '健康评测',
        component: jiankangpingce
      }
      ,{
	path: '/tijianbaogao',
        name: '体检报告',
        component: tijianbaogao
      }
      ,{
	path: '/jiankangxinxi',
        name: '健康信息',
        component: jiankangxinxi
      }
      ,{
	path: '/newstype',
        name: '健康资讯分类',
        component: newstype
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
