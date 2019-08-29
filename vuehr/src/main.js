// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import {postRequest} from "./utils/api";
import {putRequest} from "./utils/api";
import {deleteRequest} from "./utils/api";
import {getRequest} from "./utils/api";
import{initMenu} from "./utils/utils";
import 'font-awesome/css/font-awesome.min.css'

Vue.use(ElementUI);

Vue.prototype.getRequest = getRequest;
Vue.prototype.postRequest = postRequest;
Vue.prototype.deleteRequest = deleteRequest;
Vue.prototype.putRequest = putRequest;

Vue.config.productionTip = false;

/**
 * 定义一个全局导航守卫
 * to 表示目标页面的路由对象
 * from  表示从哪里来
 * next  类似于filter 中的filterchain
 */
router.beforeEach((to, from, next) => {
  if (to.path !== '/' && !window.sessionStorage.getItem("user")){
    /**要去的页面不是登录页面，并且没有登录*/
    next("/");
    return;
  }
  initMenu(router,store);
  next();
});

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
});
